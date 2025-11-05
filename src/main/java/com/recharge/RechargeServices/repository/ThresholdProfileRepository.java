package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.ThresholdProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThresholdProfileRepository extends JpaRepository<ThresholdProfile, String> {
}
