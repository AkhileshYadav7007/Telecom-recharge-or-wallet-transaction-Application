package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itn_thresholds_profile_dtls")
@Data
public class ThresholdProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String detailName;

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

    @ManyToOne
    @JoinColumn(
            name = "threshold_profile_id",
            referencedColumnName = "thres_profile_id",
            nullable = false
    )
    private ThresholdsProfile thresholdProfile;
}
