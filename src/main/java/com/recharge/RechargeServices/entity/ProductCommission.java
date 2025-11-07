package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_product_commissions")
@Data
public class ProductCommission {

    @EmbeddedId
    private ProductCommissionId id;

    @Column(name = "commissionType")
    private String commissionType;

    @Column(name = "commissionDirection")
    private String commissionDirection;

    private long commission;

    @Column(name = "createdOn")
    private LocalDateTime createdOn;

    @Column(name = "modifiedOn")
    private LocalDateTime modifiedOn;

    private String status;
}
