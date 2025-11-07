package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ServiceChargeProfileId implements Serializable {

    @Column(name = "profile_id")
    private String profileId;

    private int version;
}
