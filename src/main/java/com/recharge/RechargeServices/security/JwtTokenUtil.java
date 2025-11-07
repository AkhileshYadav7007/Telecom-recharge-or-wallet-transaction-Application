package com.recharge.RechargeServices.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SuppressWarnings("unused")
@Component
public class JwtTokenUtil {

    private static final String HMAC_ALGO = "HmacSHA256";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.accessTokenValidityInMillis:3600000}")
    private long accessTokenValidityInMillis;

    @Value("${jwt.refreshTokenValidityInMillis:86400000}")
    private long refreshTokenValidityInMillis;

    private byte[] secretBytes;

    @PostConstruct
    private void init() {
        this.secretBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
    }

    public String generateAccessToken(String username) {
        return generateToken(username, accessTokenValidityInMillis);
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, refreshTokenValidityInMillis);
    }

    private String generateToken(String username, long ttlMillis) {
        long exp = System.currentTimeMillis() + ttlMillis;
        String payload = username + "." + exp;
        String signature = sign(payload);
        String token = payload + "." + signature;
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }

    public String getUsernameFromToken(String token) {
        String decoded = decode(token);
        if (decoded == null) return null;
        String[] parts = decoded.split("\\.");
        return parts.length >= 1 ? parts[0] : null;
    }

    public boolean validateToken(String token) {
        String decoded = decode(token);
        if (decoded == null) return false;
        String[] parts = decoded.split("\\.");
        if (parts.length < 3) return false;
        String username = parts[0];
        long exp;
        try {
            exp = Long.parseLong(parts[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        String signature = parts[2];
        String payload = username + "." + exp;
        String expectedSig = sign(payload);
        return expectedSig.equals(signature) && System.currentTimeMillis() <= exp;
    }

    private String decode(String token) {
        try {
            byte[] bytes = Base64.getUrlDecoder().decode(token);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private String sign(String data) {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGO);
            SecretKeySpec keySpec = new SecretKeySpec(secretBytes, HMAC_ALGO);
            mac.init(keySpec);
            byte[] sig = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(sig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to sign token", e);
        }
    }
}
