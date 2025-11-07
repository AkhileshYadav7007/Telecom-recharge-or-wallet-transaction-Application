package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.ThresholdProfileDetails;
import com.recharge.RechargeServices.entity.ThresholdsProfile;

import java.util.List;

public interface ThresholdService {
    ThresholdsProfile createThresholdProfile(ThresholdsProfile thresholdProfile);
    ThresholdProfileDetails createThresholdProfileDetails(ThresholdProfileDetails thresholdProfileDetails);
    List<ThresholdsProfile> getAllThresholdProfiles();
    List<ThresholdProfileDetails> getAllThresholdProfileDetails();
    boolean isThresholdExceeded(String thresholdProfileId, String groupId, long amount);
}
