package com.recharge.RechargeServices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("issued_at")
    private String issuedAt;
}
