package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.TransactionHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHeaderRepository extends JpaRepository<TransactionHeader, String> {
}
