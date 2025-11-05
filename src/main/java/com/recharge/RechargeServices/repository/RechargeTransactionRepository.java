package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.RechargeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeTransactionRepository extends JpaRepository<RechargeTransaction, Long> {
}
