package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.dto.LoginRequest;
import com.recharge.RechargeServices.dto.LoginResponse;
import com.recharge.RechargeServices.dto.SignupRequest;
import com.recharge.RechargeServices.entity.ChannelUser;

public interface AuthService {
    ChannelUser signup(SignupRequest signupRequest);
    LoginResponse login(LoginRequest loginRequest);
}
