package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.Subscriber;
import com.recharge.RechargeServices.entity.SubscriberWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberWalletRepository extends JpaRepository<SubscriberWallet, Long> {
    List<SubscriberWallet> findBySubscriber(Subscriber subscriber);
}
