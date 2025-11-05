package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.TransactionItem;
import com.recharge.RechargeServices.entity.TransactionItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, TransactionItemKey> {
}
