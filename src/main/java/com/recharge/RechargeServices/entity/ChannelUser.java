package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "itn_channel_users")
public class ChannelUser {
    //ye class for channel-user

    @Id
    @Column(name = "user_id", length = 20)
    private String userId;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "password", length = 300)
    private String password;

    @Column(name = "txn_pin", length = 200)
    private String txnPin;

    @Column(name = "invalid_pin_count")
    private Integer invalidPinCount;

    @Column(name = "invalid_password_count")
    private Integer invalidPasswordCount;

    @Column(name = "category_code", length = 10)
    private String categoryCode;

    @Column(name = "user_type", length = 20)
    private String userType;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "msisdn", length = 10)
    private String msisdn;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "modified_on", nullable = false)
    private LocalDateTime modifiedOn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTxnPin() {
        return txnPin;
    }

    public void setTxnPin(String txnPin) {
        this.txnPin = txnPin;
    }

    public Integer getInvalidPinCount() {
        return invalidPinCount;
    }

    public void setInvalidPinCount(Integer invalidPinCount) {
        this.invalidPinCount = invalidPinCount;
    }

    public Integer getInvalidPasswordCount() {
        return invalidPasswordCount;
    }

    public void setInvalidPasswordCount(Integer invalidPasswordCount) {
        this.invalidPasswordCount = invalidPasswordCount;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
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
}
