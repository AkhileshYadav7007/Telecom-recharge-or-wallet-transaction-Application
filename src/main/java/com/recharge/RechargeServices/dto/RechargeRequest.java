package com.recharge.RechargeServices.dto;

import lombok.Data;

@Data
public class RechargeRequest {
    private String subscriberId;
    private String productId;
    private long amount;
    private String groupId;
}
