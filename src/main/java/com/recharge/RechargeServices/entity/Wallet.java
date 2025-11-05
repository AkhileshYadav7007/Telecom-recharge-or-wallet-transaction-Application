package com.recharge.RechargeServices.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_wallet")
public class Wallet {
    // ye class for wallet, it has wallet-id, user-id, balance, status, modified-on

    @Id
    @Column(name = "wallet_id", length = 64)
    private String walletId;

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Column(name = "user_id", length = 20)
    private String userId;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "status", length = 2)
    private String status;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;


}
