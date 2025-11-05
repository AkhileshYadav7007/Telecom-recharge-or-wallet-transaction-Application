package com.recharge.RechargeServices.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "itn_transaction_items")
public class TransactionItem {
    // ye class for transaction-item,

    @EmbeddedId
    private TransactionItemKey id;

    @Column(name = "transfer_on", nullable = false)
    private LocalDateTime transferOn;

    @Column(name = "transfer_status", length = 20)
    private String transferStatus;

    @Column(name = "user_type", length = 20)
    private String userType;

    @Column(name = "user_category", length = 50)
    private String userCategory;

    @Column(name = "approved_value")
    private Long approvedValue;

    @Column(name = "service_type", length = 50)
    private String serviceType;

    @Column(name = "product_id", length = 30)
    private String productId;

    @Column(name = "service_provider", length = 75)
    private String serviceProvider;

    @Column(name = "product_type", length = 20)
    private String productType;

    @Column(name = "recharge_type", length = 20)
    private String rechargeType;

    @Column(name = "previous_balance")
    private Long previousBalance;

    @Column(name = "post_balance")
    private Long postBalance;
}
