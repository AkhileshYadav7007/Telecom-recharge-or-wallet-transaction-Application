package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.SubscriberWallet;

import java.util.List;

public interface SubscriberWalletService {

    SubscriberWallet createSubscriberWallet(SubscriberWallet subscriberWallet);

    List<SubscriberWallet> getAllSubscriberWallets();

    SubscriberWallet getSubscriberWalletById(Long walletId);
}
