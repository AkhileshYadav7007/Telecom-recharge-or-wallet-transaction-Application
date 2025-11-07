package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.ThresholdsProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThresholdsProfileRepository extends JpaRepository<ThresholdsProfile, String> {
    List<ThresholdsProfile> findByUserType(String userType);
}
