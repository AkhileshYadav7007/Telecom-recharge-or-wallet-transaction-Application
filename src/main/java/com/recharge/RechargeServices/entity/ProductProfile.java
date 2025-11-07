package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_product_profile")
@Data
public class ProductProfile {

    @EmbeddedId
    private ProductProfileId id;

    @Column(name = "productId")
    private String productId;

    @Column(name = "marginType")
    private String marginType;

    private Long margin;

    private String status;

    @Column(name = "modifiedOn")
    private LocalDateTime modifiedOn;
}
