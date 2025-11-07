package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "itn_recharge_transactions")
@Data
public class RechargeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

    // Explicitly define FK columns
    @Column(name = "product_type", length = 20)
    private String productType;

    @Column(name = "service_provider", length = 75)
    private String serviceProvider;

    @Column(name = "recharge_type", length = 50)
    private String rechargeType;

    @Column(name = "product_code", length = 50)
    private String productCode;

    @Column(name = "api", length = 20)
    private String api;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "product_type", referencedColumnName = "product_type", insertable = false, updatable = false),
        @JoinColumn(name = "service_provider", referencedColumnName = "service_provider", insertable = false, updatable = false),
        @JoinColumn(name = "recharge_type", referencedColumnName = "recharge_type", insertable = false, updatable = false),
        @JoinColumn(name = "product_code", referencedColumnName = "product_code", insertable = false, updatable = false),
        @JoinColumn(name = "api", referencedColumnName = "api", insertable = false, updatable = false)
    })
    private ProductProfile productProfile;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private SubscriberWallet wallet;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status")
    private RechargeTransactionStatus transactionStatus;

    @Column(name = "transaction_date")
    private Timestamp transactionDate;
}
