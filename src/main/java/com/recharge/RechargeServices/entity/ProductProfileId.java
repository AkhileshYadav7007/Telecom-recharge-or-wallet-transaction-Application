package com.recharge.RechargeServices.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProductProfileId implements Serializable {

    private String productType;
    private String serviceProvider;
    private String rechargeType;
    private String productCode;
    private String api;
}
