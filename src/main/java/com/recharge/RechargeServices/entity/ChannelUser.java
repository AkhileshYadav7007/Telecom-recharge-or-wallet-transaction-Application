package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "itn_channel_users")
@Data
public class ChannelUser {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "txn_pin")
    private String txnPin;

    @Column(name = "invalid_pin_count")
    private Integer invalidPinCount;

    @Column(name = "invalid_password_count")
    private Integer invalidPasswordCount;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String msisdn;

    private String status;

    @Column(name = "firm_name")
    private String firmName;

    @Column(name = "alter_msisdn")
    private String alterMsisdn;

    @Column(name = "email_id")
    private String emailId;

    private String city;

    private String state;

    private String district;

    private String address;

    private String pan;

    private String pincode;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "thres_profile_id")
    private String thresProfileId;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "deleted_on")
    private LocalDateTime deletedOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "suspension_reason")
    private String suspensionReason;

    @Column(name = "last_login_on")
    private LocalDateTime lastLoginOn;

    @Column(name = "first_login")
    private String firstLogin;

    @Column(name = "suspend_reason")
    private String suspendReason;

    private String manager;

    @Column(name = "otp_status")
    private String otpStatus;

    @Column(name = "dmt_type")
    private String dmtType;

    @Column(name = "pan_file_path")
    private String panFilePath;

    @Column(name = "aadhar_file_path")
    private String aadharFilePath;

    @Column(name = "gst_number")
    private String gstNumber;

    private String aadhaar;

    @Column(name = "incometax_proof_name")
    private String incometaxProofName;

    @Column(name = "incometax_proof_id")
    private String incometaxProofId;

    @Column(name = "incometax_proof_file")
    private String incometaxProofFile;

    @Column(name = "servicetax_proof_name")
    private String servicetaxProofName;

    @Column(name = "servicetax_proof_id")
    private String servicetaxProofId;

    @Column(name = "servicetax_proof_file")
    private String servicetaxProofFile;

    @Column(name = "id_proof_name")
    private String idProofName;

    @Column(name = "id_proof_id")
    private String idProofId;

    @Column(name = "id_proof_file")
    private String idProofFile;

    @Column(name = "address_proof_name")
    private String addressProofName;

    @Column(name = "address_proof_id")
    private String addressProofId;

    @Column(name = "address_proof_file")
    private String addressProofFile;
}
