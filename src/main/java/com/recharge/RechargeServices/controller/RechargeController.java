package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.dto.RechargeRequest;
import com.recharge.RechargeServices.dto.RechargeResponse;
import com.recharge.RechargeServices.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recharge")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @PostMapping
    public RechargeResponse performRecharge(@RequestBody RechargeRequest request) {
        return rechargeService.performRecharge(request);
    }
}
