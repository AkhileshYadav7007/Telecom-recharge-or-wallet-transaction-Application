package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ServiceChargeDetailId implements Serializable {

    @Column(name = "detail_id")
    private String detailId;

    @Column(name = "user_category")
    private String userCategory;
}
