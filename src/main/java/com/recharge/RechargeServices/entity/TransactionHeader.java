package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "itn_transaction_header")
public class TransactionHeader {
    // ye class for transaction-header,
    // it has transfer-id, transfer-on, payer-user-id, payee-user-id,

    @Id
    @Column(name = "transfer_id", length = 20)
    private String transferId;

    @Column(name = "transfer_on")
    private LocalDateTime transferOn;

    @Column(name = "payer_user_id", length = 20)
    private String payerUserId;

    @Column(name = "payee_user_id", length = 20)
    private String payeeUserId;

    @Column(name = "requested_value")
    private Long requestedValue;

    @Column(name = "transfer_status", length = 20)
    private String transferStatus;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on", nullable = false)
    private LocalDateTime modifiedOn;

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public LocalDateTime getTransferOn() {
        return transferOn;
    }

    public void setTransferOn(LocalDateTime transferOn) {
        this.transferOn = transferOn;
    }

    public String getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId;
    }

    public String getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(String payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public Long getRequestedValue() {
        return requestedValue;
    }

    public void setRequestedValue(Long requestedValue) {
        this.requestedValue = requestedValue;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
        modifiedOn = LocalDateTime.now();
        transferOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedOn = LocalDateTime.now();
    }
}
