package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.dto.LoginRequest;
import com.recharge.RechargeServices.dto.LoginResponse;
import com.recharge.RechargeServices.dto.SignupRequest;
import com.recharge.RechargeServices.entity.ChannelUser;
import com.recharge.RechargeServices.repository.ChannelUserRepository;
import com.recharge.RechargeServices.security.JwtTokenUtil;
import com.recharge.RechargeServices.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ChannelUserRepository channelUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.accessTokenValidityInMillis:3600000}")
    private long accessTokenValidityInMillis;

    @Override
    public ChannelUser signup(SignupRequest signupRequest) {
        ChannelUser user = new ChannelUser();
        // Set both userId (Primary Key) and userName from the request
        user.setUserId(signupRequest.getUsername());
        user.setUserName(signupRequest.getUsername());
        user.setEmailId(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setModifiedOn(LocalDateTime.now());
        // Set a default status
        user.setStatus("ACTIVE");
        return channelUserRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        String username = authentication.getName();
        String accessToken = jwtTokenUtil.generateAccessToken(username);
        String refreshToken = jwtTokenUtil.generateRefreshToken(username);

        return LoginResponse.builder()
                .tokenType("Bearer")
                .accessToken(accessToken)
                .expiresIn(accessTokenValidityInMillis / 1000)
                .refreshToken(refreshToken)
                .issuedAt(LocalDateTime.now().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT))
                .build();
    }
}
