package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_mnytfr_srvchrg")
@Data
public class MoneyTransferServiceCharge {

    @Id
    @Column(name = "srvc_chrg_id")
    private String serviceChargeId;

    @Column(name = "srvc_chrg_ver")
    private int serviceChargeVersion;

    @Column(name = "min_tfr_amt")
    private long minTransferAmount;

    @Column(name = "max_tfr_amt")
    private long maxTransferAmount;

    private String mode;

    @Column(name = "srvc_chrg_dtls_id")
    private String serviceChargeDetailsId;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    private String status;
}
