package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.Subscriber;

import java.util.List;

public interface SubscriberService {

    Subscriber createSubscriber(Subscriber subscriber);

    List<Subscriber> getAllSubscribers();

    Subscriber getSubscriberById(String subscriberId);
}
