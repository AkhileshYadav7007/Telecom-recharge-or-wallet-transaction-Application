package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.entity.ThresholdProfile;
import com.recharge.RechargeServices.entity.ThresholdProfileDetails;
import com.recharge.RechargeServices.repository.ThresholdProfileDetailsRepository;
import com.recharge.RechargeServices.repository.ThresholdProfileRepository;
import com.recharge.RechargeServices.service.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThresholdServiceImpl implements ThresholdService {

    @Autowired
    private ThresholdProfileRepository thresholdProfileRepository;

    @Autowired
    private ThresholdProfileDetailsRepository thresholdProfileDetailsRepository;

    @Override
    public ThresholdProfile createThresholdProfile(ThresholdProfile thresholdProfile) {
        return thresholdProfileRepository.save(thresholdProfile);
    }

    @Override
    public ThresholdProfileDetails createThresholdProfileDetails(ThresholdProfileDetails thresholdProfileDetails) {
        return thresholdProfileDetailsRepository.save(thresholdProfileDetails);
    }

    @Override
    public List<ThresholdProfile> getAllThresholdProfiles() {
        return thresholdProfileRepository.findAll();
    }

    @Override
    public List<ThresholdProfileDetails> getAllThresholdProfileDetails() {
        return thresholdProfileDetailsRepository.findAll();
    }

    @Override
    public boolean isThresholdExceeded(String userType, String groupId, long amount) {
        Optional<ThresholdProfileDetails> details = thresholdProfileDetailsRepository.findByThresholdProfile_UserTypeAndGroupId(userType, groupId);
        if (details.isPresent()) {
            ThresholdProfileDetails profile = details.get();
            // Assuming the check is for payer amount for now
            return amount > profile.getPayerAmt();
        }
        return false; // Or throw an exception if a profile is always expected
    }
}
