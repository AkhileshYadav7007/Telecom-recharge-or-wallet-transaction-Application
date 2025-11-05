package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.entity.RechargeTransaction;
import com.recharge.RechargeServices.service.RechargeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class RechargeTransactionController {

    @Autowired
    private RechargeTransactionService transactionService;

    @PostMapping
    public RechargeTransaction createRechargeTransaction(@RequestBody RechargeTransaction transaction) {
        return transactionService.createRechargeTransaction(transaction);
    }

    @GetMapping
    public List<RechargeTransaction> getAllRechargeTransactions() {
        return transactionService.getAllRechargeTransactions();
    }

    @GetMapping("/{transactionId}")
    public RechargeTransaction getRechargeTransactionById(@PathVariable Long transactionId) {
        return transactionService.getRechargeTransactionById(transactionId);
    }
}
