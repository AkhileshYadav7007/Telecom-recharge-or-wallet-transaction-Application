package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.dto.RechargeRequest;
import com.recharge.RechargeServices.dto.RechargeResponse;
import com.recharge.RechargeServices.entity.*;
import com.recharge.RechargeServices.exception.*;
import com.recharge.RechargeServices.repository.ProductProfileRepository;
import com.recharge.RechargeServices.repository.RechargeTransactionRepository;
import com.recharge.RechargeServices.repository.SubscriberWalletRepository;
import com.recharge.RechargeServices.service.RechargeService;
import com.recharge.RechargeServices.service.SubscriberService;
import com.recharge.RechargeServices.service.ThresholdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {
    private final SubscriberService subscriberService;
    private final SubscriberWalletRepository walletRepository;
    private final ThresholdService thresholdService;
    private final ProductProfileRepository productProfileRepository;
    private final RechargeTransactionRepository transactionRepository;
    private final PlatformTransactionManager transactionManager;


    public RechargeServiceImpl(SubscriberService subscriberService,
                               SubscriberWalletRepository walletRepository,
                               ThresholdService thresholdService,
                               ProductProfileRepository productProfileRepository,
                               RechargeTransactionRepository transactionRepository,
                               PlatformTransactionManager transactionManager) {
        this.subscriberService = subscriberService;
        this.walletRepository = walletRepository;
        this.thresholdService = thresholdService;
        this.productProfileRepository = productProfileRepository;
        this.transactionRepository = transactionRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    @Transactional
    public RechargeResponse performRecharge(RechargeRequest request) {

        Subscriber subscriber = subscriberService.getSubscriberById(request.getSubscriberId());
        ProductProfile product = productProfileRepository.findByProductId(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + request.getProductId()));
        List<SubscriberWallet> wallets = walletRepository.findBySubscriber(subscriber);
        if (wallets.isEmpty()) {
            throw new ResourceNotFoundException("Wallet not found for subscriber: " + subscriber.getSubscriberId());
        }
        SubscriberWallet wallet = wallets.getFirst();


        RechargeTransaction transaction = new RechargeTransaction();
        transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        BigDecimal rechargeAmount = BigDecimal.valueOf(request.getAmount());
        transaction.setAmount(rechargeAmount);
        transaction.setSubscriber(subscriber);
        transaction.setProductProfile(product);
        transaction.setWallet(wallet);


        transaction.setProductType(product.getId().getProductType());
        transaction.setServiceProvider(product.getId().getServiceProvider());
        transaction.setRechargeType(product.getId().getRechargeType());
        transaction.setProductCode(product.getId().getProductCode());
        transaction.setApi(product.getId().getApi());

        try {

            if (subscriber.getThresholdProfile() == null) {
                throw new BusinessValidationException("Subscriber has no threshold profile assigned.");
            }


            long amountInSmallestUnit = request.getAmount() * 100;

            boolean thresholdExceeded = thresholdService.isThresholdExceeded(
                    subscriber.getThresholdProfile().getThresholdProfileId(),
                    request.getGroupId(),
                    amountInSmallestUnit
            );
            if (thresholdExceeded) {
                throw new ThresholdExceededException("Transaction threshold exceeded.");
            }

            if (wallet.getBalance().compareTo(rechargeAmount) < 0) {
                throw new InsufficientBalanceException("Insufficient balance for the transaction.");
            }

            // Update wallet balance.
            wallet.setBalance(wallet.getBalance().subtract(rechargeAmount));
            walletRepository.save(wallet);

            // Mark transaction as successful and save.
            transaction.setTransactionStatus(RechargeTransactionStatus.SUCCESS);
            transactionRepository.save(transaction);

            return new RechargeResponse(true, "Recharge successful");
        } catch (RuntimeException e) {
            // Log the failed transaction in a new, separate transaction.
            TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
            transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            transactionTemplate.execute(status -> {
                transaction.setTransactionStatus(RechargeTransactionStatus.FAILED);
                transactionRepository.save(transaction);
                return null;
            });

            throw e;
        }
    }
}
