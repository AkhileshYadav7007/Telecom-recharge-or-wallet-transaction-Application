package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.dto.RechargeRequest;
import com.recharge.RechargeServices.dto.RechargeResponse;

public interface RechargeService {
    RechargeResponse performRecharge(RechargeRequest request);
}
