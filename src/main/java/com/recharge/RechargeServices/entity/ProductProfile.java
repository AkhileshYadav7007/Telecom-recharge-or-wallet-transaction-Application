package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "itn_product_profile")
@Data
public class ProductProfile {

    @EmbeddedId
    private ProductProfileId id;

    @Column(unique = true)
    private String productId;

    private String marginType;
    private Long margin;
    private String status;

    @Column(name = "modifiedOn")
    private Timestamp modifiedOn;
}
