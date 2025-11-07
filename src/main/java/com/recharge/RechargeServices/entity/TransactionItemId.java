package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class TransactionItemId implements Serializable {

    @Column(name = "transfer_id")
    private String transferId;

    @Column(name = "party_id")
    private String partyId;

    @Column(name = "second_party")
    private String secondParty;

    @Column(name = "transaction_type")
    private String transactionType;
}
