package com.recharge.RechargeServices.controller;
import com.recharge.RechargeServices.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody(required = false) LoginRequest loginRequest,
                                                     @RequestParam(required = false) String username,
                                                     @RequestParam(required = false) String password) {
        String user;
        String pass;

        if (loginRequest != null && loginRequest.getUsername() != null) {
            user = loginRequest.getUsername();
            pass = loginRequest.getPassword();
        } else {
            user = username;
            pass = password;
        }

        if (user == null || pass == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "username and password are required"));
        }

        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user, pass));
            UserDetails userDetails = (UserDetails) auth.getPrincipal();

            String accessToken = jwtTokenUtil.generateAccessToken(userDetails.getUsername());
            String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails.getUsername());

            return ResponseEntity.ok(Map.of(
                    "token_type", "Bearer",
                    "access_token", accessToken,
                    "refresh_token", refreshToken,
                    "expires_in", 3600,
                    "issued_at", Instant.now().toString()
            ));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
        }
    }
}
