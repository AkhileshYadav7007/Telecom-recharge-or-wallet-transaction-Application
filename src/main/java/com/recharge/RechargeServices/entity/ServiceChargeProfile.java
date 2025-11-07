package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_service_charge_profile")
@Data
public class ServiceChargeProfile {

    @EmbeddedId
    private ServiceChargeProfileId id;

    @Column(name = "detail_id")
    private String detailId;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    private String status;
}
