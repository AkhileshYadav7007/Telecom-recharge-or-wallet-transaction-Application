package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "itn_mnytfr_srvchrg_dtls")
@Data
public class MoneyTransferServiceChargeDetail {

    @EmbeddedId
    private MoneyTransferServiceChargeDetailId id;

    private String type;

    @Column(name = "usr_ctgry_1")
    private String userCategory1;

    @Column(name = "srvc_amt_1")
    private long serviceAmount1;

    @Column(name = "usr_ctgry_2")
    private String userCategory2;

    @Column(name = "srvc_amt_2")
    private long serviceAmount2;

    @Column(name = "usr_ctgry_3")
    private String userCategory3;

    @Column(name = "srvc_amt_3")
    private long serviceAmount3;

    @Column(name = "usr_ctgry_4")
    private String userCategory4;

    @Column(name = "srvc_amt_4")
    private long serviceAmount4;

    @Column(name = "usr_ctgry_5")
    private String userCategory5;

    @Column(name = "srvc_amt_5")
    private long serviceAmount5;

    private String status;
}
