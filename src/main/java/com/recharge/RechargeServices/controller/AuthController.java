package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.dto.LoginRequest;
import com.recharge.RechargeServices.dto.LoginResponse;
import com.recharge.RechargeServices.dto.SignupRequest;
import com.recharge.RechargeServices.entity.ChannelUser;
import com.recharge.RechargeServices.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ChannelUser signup(@RequestBody SignupRequest signupRequest) {
        return authService.signup(signupRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
