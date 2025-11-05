package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.entity.SubscriberWallet;
import com.recharge.RechargeServices.repository.SubscriberWalletRepository;
import com.recharge.RechargeServices.service.SubscriberWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberWalletServiceImpl implements SubscriberWalletService {

    @Autowired
    private SubscriberWalletRepository subscriberWalletRepository;

    @Override
    public SubscriberWallet createSubscriberWallet(SubscriberWallet subscriberWallet) {
        return subscriberWalletRepository.save(subscriberWallet);
    }

    @Override
    public List<SubscriberWallet> getAllSubscriberWallets() {
        return subscriberWalletRepository.findAll();
    }

    @Override
    public SubscriberWallet getSubscriberWalletById(Long walletId) {
        return subscriberWalletRepository.findById(walletId).orElse(null);
    }
}
