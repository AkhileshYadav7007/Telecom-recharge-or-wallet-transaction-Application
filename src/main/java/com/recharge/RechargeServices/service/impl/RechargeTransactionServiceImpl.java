package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.entity.RechargeTransaction;
import com.recharge.RechargeServices.repository.RechargeTransactionRepository;
import com.recharge.RechargeServices.service.RechargeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeTransactionServiceImpl implements RechargeTransactionService {

    @Autowired
    private RechargeTransactionRepository transactionRepository;

    @Override
    public RechargeTransaction createRechargeTransaction(RechargeTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<RechargeTransaction> getAllRechargeTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public RechargeTransaction getRechargeTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }
}
