package com.recharge.RechargeServices.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "itn_subscribers")
@Data
public class Subscriber {

    @Id
    @Column(name = "subscriber_id")
    private String subscriberId;

    @ManyToOne
    @JoinColumn(name = "thres_profile_id")
    private ThresholdProfile thresholdProfile;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "msisdn")
    private String msisdn;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SubscriberStatus status;

    @Column(name = "otp")
    private String otp;

    @Column(name = "created_on", updatable = false)
    private Timestamp createdOn;

    @Column(name = "deleted_on")
    private Timestamp deletedOn;

    @Column(name = "last_modified_on")
    private Timestamp lastModifiedOn;
}
