package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.RechargeTransaction;

import java.util.List;

public interface RechargeTransactionService {

    RechargeTransaction createRechargeTransaction(RechargeTransaction transaction);

    List<RechargeTransaction> getAllRechargeTransactions();

    RechargeTransaction getRechargeTransactionById(Long transactionId);
}
