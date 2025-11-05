package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.entity.Subscriber;
import com.recharge.RechargeServices.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.createSubscriber(subscriber);
    }

    @GetMapping
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.getAllSubscribers();
    }

    @GetMapping("/{subscriberId}")
    public Subscriber getSubscriberById(@PathVariable String subscriberId) {
        return subscriberService.getSubscriberById(subscriberId);
    }
}
