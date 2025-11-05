package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.ThresholdProfileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThresholdProfileDetailsRepository extends JpaRepository<ThresholdProfileDetails, String> {
    Optional<ThresholdProfileDetails> findByThresholdProfile_UserTypeAndGroupId(String userType, String groupId);
}
