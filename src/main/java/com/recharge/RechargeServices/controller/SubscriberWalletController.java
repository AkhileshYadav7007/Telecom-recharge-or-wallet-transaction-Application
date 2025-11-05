package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.entity.SubscriberWallet;
import com.recharge.RechargeServices.service.SubscriberWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class SubscriberWalletController {

    @Autowired
    private SubscriberWalletService subscriberWalletService;

    @PostMapping
    public SubscriberWallet createSubscriberWallet(@RequestBody SubscriberWallet subscriberWallet) {
        return subscriberWalletService.createSubscriberWallet(subscriberWallet);
    }

    @GetMapping
    public List<SubscriberWallet> getAllSubscriberWallets() {
        return subscriberWalletService.getAllSubscriberWallets();
    }

    @GetMapping("/{walletId}")
    public SubscriberWallet getSubscriberWalletById(@PathVariable Long walletId) {
        return subscriberWalletService.getSubscriberWalletById(walletId);
    }
}
