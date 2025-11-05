package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, String> {
    List<Wallet> findByUserId(String userId);
}
