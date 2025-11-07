package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.entity.Subscriber;
import com.recharge.RechargeServices.repository.SubscriberRepository;
import com.recharge.RechargeServices.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    //this service will handle subscriber related operations like create, update, delete, get subscriber details

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public Subscriber createSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    @Override
    public Subscriber getSubscriberById(String subscriberId) {
        return subscriberRepository.findById(subscriberId).orElse(null);
    }
}
