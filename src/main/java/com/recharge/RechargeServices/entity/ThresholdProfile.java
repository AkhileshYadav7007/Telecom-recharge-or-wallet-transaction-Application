package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "itn_thresholds_profiles")
@Data
public class ThresholdProfile {

    @Id
    @Column(name = "thres_profile_id")
    private String thresProfileId;
    @Column(name = "name")
    private String name;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "status")
    private String status;

    // Getters and Setters are provided by Lombok's @Data
}
