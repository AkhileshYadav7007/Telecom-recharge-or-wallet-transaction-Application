package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "itn_transaction_header")
@Data
public class TransactionHeader {

    @Id
    @Column(name = "transfer_id")
    private String transferId;

    @Column(name = "transfer_on")
    private LocalDateTime transferOn;

    @Column(name = "payer_user_id")
    private String payerUserId;

    @Column(name = "payer_account_id")
    private String payerAccountId;

    @Column(name = "payee_user_id")
    private String payeeUserId;

    @Column(name = "payee_account_id")
    private String payeeAccountId;

    @Column(name = "requested_value")
    private long requestedValue;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "recharge_type")
    private String rechargeType;

    @Column(name = "reconciliation_done")
    private String reconciliationDone;

    @Column(name = "reconciliation_date")
    private String reconciliationDate;

    @Column(name = "reconciliation_by")
    private String reconciliationBy;

    @Column(name = "details_1")
    private String details1;

    @Column(name = "details_2")
    private String details2;

    @Column(name = "details_3")
    private String details3;

    @Column(name = "details_4")
    private String details4;

    @Column(name = "details_5")
    private String details5;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    private String remarks;

    @Column(name = "total_commission")
    private long totalCommission;

    @Column(name = "admn_srvc_chrg")
    private long adminServiceCharge;

    @Column(name = "dist_srvc_chrg")
    private long distributorServiceCharge;

    @Column(name = "rtlr_srvc_chrg")
    private long retailerServiceCharge;

    @Column(name = "total_service_charge")
    private long totalServiceCharge;

    @Column(name = "operator_txn_id")
    private String operatorTransactionId;

    @Column(name = "aggregator_txn_id")
    private String aggregatorTransactionId;

    @Column(name = "details_6")
    private String details6;

    @Column(name = "details_7")
    private String details7;

    @Column(name = "details_8")
    private String details8;

    @Column(name = "details_9")
    private String details9;

    @Column(name = "details_10")
    private String details10;

    @Column(name = "tax_details_1")
    private long taxDetails1;

    @Column(name = "tax_details_2")
    private long taxDetails2;

    @Column(name = "tax_details_3")
    private long taxDetails3;

    @Column(name = "tax_details_4")
    private long taxDetails4;

    @Column(name = "tax_details_5")
    private long taxDetails5;

    @Column(name = "tax_details_6")
    private long taxDetails6;

    @Column(name = "tax_details_7")
    private long taxDetails7;


}
