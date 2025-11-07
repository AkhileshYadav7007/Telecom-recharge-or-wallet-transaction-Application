package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "itn_service_charge_details")
@Data
public class ServiceChargeDetail {

    @EmbeddedId
    private ServiceChargeDetailId id;

    private Integer version;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "recharge_type")
    private String rechargeType;

    @Column(name = "srvc_chrg_type")
    private String serviceChargeType;

    @Column(name = "service_charge")
    private Long serviceCharge;

    private String status;
}
