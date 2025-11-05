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

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "product_type", referencedColumnName = "product_type"),
        @JoinColumn(name = "service_provider", referencedColumnName = "service_provider"),
        @JoinColumn(name = "recharge_type", referencedColumnName = "recharge_type"),
        @JoinColumn(name = "product_code", referencedColumnName = "product_code"),
        @JoinColumn(name = "api", referencedColumnName = "api")
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
