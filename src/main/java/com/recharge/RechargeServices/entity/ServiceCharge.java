package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_service_charge")
@Data
public class ServiceCharge {

    @Id
    @Column(name = "srvc_chrg_id")
    private String serviceChargeId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "srvc_chrg_type")
    private String serviceChargeType;

    @Column(name = "service_charge")
    private String serviceCharge;

    private String payer;

    @Column(name = "productId")
    private String productId;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "recharge_type")
    private String rechargeType;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    private String status;
}
