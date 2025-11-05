package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.exception.*;
import com.recharge.RechargeServices.dto.RechargeRequest;
import com.recharge.RechargeServices.dto.RechargeResponse;
import com.recharge.RechargeServices.entity.*;
import com.recharge.RechargeServices.repository.ProductProfileRepository;
import com.recharge.RechargeServices.repository.RechargeTransactionRepository;
import com.recharge.RechargeServices.repository.SubscriberWalletRepository;
import com.recharge.RechargeServices.service.RechargeService;
import com.recharge.RechargeServices.service.SubscriberService;
import com.recharge.RechargeServices.service.ThresholdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
public class RechargeServiceImpl implements RechargeService {
    private final SubscriberService subscriberService;
    private final SubscriberWalletRepository walletRepository;
    private final ThresholdService thresholdService;
    private final ProductProfileRepository productProfileRepository;
    private final RechargeTransactionRepository transactionRepository;

    // Using constructor injection - a best practice
    public RechargeServiceImpl(SubscriberService subscriberService,
                               SubscriberWalletRepository walletRepository,
                               ThresholdService thresholdService,
                               ProductProfileRepository productProfileRepository,
                               RechargeTransactionRepository transactionRepository) {
        this.subscriberService = subscriberService;
        this.walletRepository = walletRepository;
        this.thresholdService = thresholdService;
        this.productProfileRepository = productProfileRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public RechargeResponse performRecharge(RechargeRequest request) {
        // Initialize transaction details early
        RechargeTransaction transaction = new RechargeTransaction();
        transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        BigDecimal rechargeAmount = BigDecimal.valueOf(request.getAmount());
        transaction.setAmount(rechargeAmount);

        try {
            Subscriber subscriber = subscriberService.getSubscriberById(request.getSubscriberId());
            transaction.setSubscriber(subscriber);

            ProductProfile product = productProfileRepository.findByProductId(request.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + request.getProductId()));
            transaction.setProductProfile(product);

            if (subscriber.getThresholdProfile() == null) {
                throw new BusinessValidationException("Subscriber has no threshold profile assigned.");
            }

            // Check transaction threshold
            boolean thresholdExceeded = thresholdService.isThresholdExceeded(
                    subscriber.getThresholdProfile().getUserType(),
                    request.getGroupId(),
                    request.getAmount()
            );
            if (thresholdExceeded) {
                throw new ThresholdExceededException("Transaction threshold exceeded.");
            }

            // Check wallet balance
            SubscriberWallet wallet = walletRepository.findBySubscriber(subscriber)
                    .orElseThrow(() -> new ResourceNotFoundException("Wallet not found for subscriber: " + subscriber.getId()));
            transaction.setWallet(wallet);

            if (wallet.getBalance().compareTo(rechargeAmount) < 0) {
                throw new InsufficientBalanceException("Insufficient balance for the transaction.");
            }

            // Perform external recharge logic here
            // If the external call fails, an exception will be thrown and the transaction will be rolled back.

            // Update wallet balance
            wallet.setBalance(wallet.getBalance().subtract(rechargeAmount));
            walletRepository.save(wallet);

            // Mark transaction as successful and save
            finalizeTransaction(transaction, RechargeTransactionStatus.SUCCESS);
            return new RechargeResponse(true, "Recharge successful");
        } catch (Exception e) {
            // Any exception will mark the transaction as failed
            finalizeTransaction(transaction, RechargeTransactionStatus.FAILED);
            // Re-throw the original exception to be handled by a global exception handler
            throw e;
        }
    }

    private void finalizeTransaction(RechargeTransaction transaction, RechargeTransactionStatus status) {
        transaction.setTransactionStatus(status);
        transactionRepository.save(transaction);
    }
}
