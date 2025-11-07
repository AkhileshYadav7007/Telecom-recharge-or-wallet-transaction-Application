package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class MoneyTransferServiceChargeDetailId implements Serializable {

    @Column(name = "srvc_chrg_dtls_id")
    private String serviceChargeDetailsId;

    @Column(name = "from_amt")
    private long fromAmount;

    @Column(name = "to_amt")
    private long toAmount;
}
