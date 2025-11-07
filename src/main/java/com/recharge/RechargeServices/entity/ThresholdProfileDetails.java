package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "itn_thresholds_profile_dtls")
@Data
public class ThresholdProfileDetails {

    @Id
    @Column(name = "thres_profile_dtls_id")
    private String thresholdProfileDetailsId;

    @Column(name = "thres_profile_id")
    private String thresholdProfileId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "payer_count")
    private long payerCount;

    @Column(name = "payer_amt")
    private long payerAmount;

    @Column(name = "payee_count")
    private long payeeCount;

    @Column(name = "payee_amt")
    private long payeeAmount;
}
