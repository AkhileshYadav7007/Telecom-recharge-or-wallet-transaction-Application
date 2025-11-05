package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itn_thresholds_profile_dtls")
@Data
public class ThresholdProfileDetails {

    @Id
    @Column(name = "thres_profile_dtls_id")
    private String thresProfileDtlsId;

    @ManyToOne
    @JoinColumn(name = "thres_profile_id")
    private ThresholdProfile thresholdProfile;

    @Column(name = "group_id")
    private String groupId;
    @Column(name = "payer_count")
    private Long payerCount;
    @Column(name = "payer_amt")
    private Long payerAmt;
    @Column(name = "payee_count")
    private Long payeeCount;
    @Column(name = "payee_amt")
    private Long payeeAmt;

    // Getters and Setters are provided by Lombok's @Data
}
