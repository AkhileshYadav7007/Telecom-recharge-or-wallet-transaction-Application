package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "itn_thresholds_profiles")
@Data
public class ThresholdsProfile {

    @Id
    @Column(name = "thres_profile_id")
    private String thresholdProfileId;

    private String name;

    @Column(name = "user_type")
    private String userType;

    private String status;
}
