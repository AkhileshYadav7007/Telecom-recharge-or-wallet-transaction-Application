package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.entity.ThresholdProfileDetails;
import com.recharge.RechargeServices.entity.ThresholdsProfile;
import com.recharge.RechargeServices.exception.BusinessValidationException;
import com.recharge.RechargeServices.repository.ThresholdProfileDetailsRepository;
import com.recharge.RechargeServices.repository.ThresholdsProfileRepository;
import com.recharge.RechargeServices.service.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class ThresholdServiceImpl implements ThresholdService {

    @Autowired
    private ThresholdsProfileRepository thresholdsProfileRepository;

    @Autowired
    private ThresholdProfileDetailsRepository thresholdProfileDetailsRepository;

    @Override
    public ThresholdsProfile createThresholdProfile(ThresholdsProfile thresholdProfile) {
        // Manually generate a unique ID
        String id = "TP" + new Date().getTime();
        thresholdProfile.setThresholdProfileId(id);
        return thresholdsProfileRepository.save(thresholdProfile);
    }

    @Override
    public ThresholdProfileDetails createThresholdProfileDetails(ThresholdProfileDetails thresholdProfileDetails) {
        ThresholdsProfile thresholdsProfile = thresholdsProfileRepository.findById(thresholdProfileDetails.getThresholdProfileId())
                .orElseThrow(() -> new RuntimeException("ThresholdsProfile not found"));
        thresholdProfileDetails.setThresholdProfileId(thresholdsProfile.getThresholdProfileId());

        Optional<ThresholdProfileDetails> existingDetails = thresholdProfileDetailsRepository.findByThresholdProfileIdAndGroupId(
                thresholdProfileDetails.getThresholdProfileId(), thresholdProfileDetails.getGroupId());

        if (existingDetails.isPresent()) {
            throw new BusinessValidationException("Threshold profile details already exist for the given profile and group ID.");
        }

        // Manually generate a unique ID
        String id = "TD" + new Date().getTime();
        thresholdProfileDetails.setThresholdProfileDetailsId(id);

        return thresholdProfileDetailsRepository.save(thresholdProfileDetails);
    }

    @Override
    public List<ThresholdsProfile> getAllThresholdProfiles() {
        return thresholdsProfileRepository.findAll();
    }

    @Override
    public List<ThresholdProfileDetails> getAllThresholdProfileDetails() {
        return thresholdProfileDetailsRepository.findAll();
    }

    @Override
    public boolean isThresholdExceeded(String thresholdProfileId, String groupId, long amount) {
        Optional<ThresholdProfileDetails> details = thresholdProfileDetailsRepository.findByThresholdProfileIdAndGroupId(thresholdProfileId, groupId);

        if (details.isEmpty()) {
            throw new BusinessValidationException("No threshold details found for profile ID: " + thresholdProfileId + " and group ID: " + groupId);
        }

        ThresholdProfileDetails profile = details.get();

        return amount > profile.getPayerAmount();
    }
}
