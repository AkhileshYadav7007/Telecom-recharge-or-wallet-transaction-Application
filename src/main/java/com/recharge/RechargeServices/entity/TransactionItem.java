package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_transaction_items")
@Data
public class TransactionItem {

    @EmbeddedId
    private TransactionItemId id;

    @Column(name = "transfer_on")
    private LocalDateTime transferOn;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_category")
    private String userCategory;

    @Column(name = "approved_value")
    private long approvedValue;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "recharge_type")
    private String rechargeType;

    @Column(name = "previous_balance")
    private long previousBalance;

    @Column(name = "post_balance")
    private long postBalance;
}
