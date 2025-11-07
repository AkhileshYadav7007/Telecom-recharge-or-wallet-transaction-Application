package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_wallet")
@Data
public class Wallet {

    @Id
    @Column(name = "wallet_id")
    private String walletId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_type")
    private String userType;

    private String msisdn;

    @Column(name = "wallet_type")
    private String walletType;

    @Column(name = "prev_balance")
    private long prevBalance;

    private long balance;

    @Column(name = "net_credit")
    private long netCredit;

    @Column(name = "net_debit")
    private long netDebit;

    @Column(name = "last_transation_type")
    private String lastTransactionType;

    @Column(name = "last_transation_id")
    private String lastTransactionId;

    private String status;

    @Column(name = "wallet_limit")
    private long walletLimit;

    @Column(name = "last_transation_on")
    private LocalDateTime lastTransactionOn;

    @Column(name = "operator_Code")
    private String operatorCode;

    @Column(name = "first_transation_on")
    private LocalDateTime firstTransactionOn;
}
