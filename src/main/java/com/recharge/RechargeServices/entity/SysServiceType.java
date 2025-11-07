package com.recharge.RechargeServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sys_service_types")
@Data
public class SysServiceType {

    @Id
    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_name")
    private String serviceName;

    private String status;

    @Column(name = "is_financial")
    private String isFinancial;
}
