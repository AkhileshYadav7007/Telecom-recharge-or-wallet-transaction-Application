package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProductCommissionId implements Serializable {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "recharge_type")
    private String rechargeType;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_category")
    private String userCategory;
}
