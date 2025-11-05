package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.Subscriber;
import com.recharge.RechargeServices.entity.SubscriberWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberWalletRepository extends JpaRepository<SubscriberWallet, Long> {
    SubscriberWallet findBySubscriber(Subscriber subscriber);
}
