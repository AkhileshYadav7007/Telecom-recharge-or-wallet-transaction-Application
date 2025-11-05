package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "itn_thresholds_profile_dtls")
public class ThresholdProfileDetail {
    // ye class for threshold-profile-details, it has id,
    // profile-id, group-id, payer-count, payer-amount, payee-count, payee-amount

    @Id
    @Column(name = "thres_profile_dtls_id", length = 20)
    private String thresholdProfileDetailsId;

    @Column(name = "thres_profile_id", length = 20)
    private String thresholdProfileId;

    @Column(name = "group_id", length = 20)
    private String groupId;

    @Column(name = "payer_count")
    private Long payerCount;

    @Column(name = "payer_amt")
    private Long payerAmount;

    @Column(name = "payee_count")
    private Long payeeCount;

    @Column(name = "payee_amt")
    private Long payeeAmount;
}
