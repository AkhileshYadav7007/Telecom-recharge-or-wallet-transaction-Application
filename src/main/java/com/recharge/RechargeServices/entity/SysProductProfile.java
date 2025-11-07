package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "sys_product_profiles")
@Data
public class SysProductProfile {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "recharge_type")
    private String rechargeType;

    @Column(name = "product_code")
    private String productCode;

    private String api;

    private String status;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "image_url")
    private String imageUrl;
}
