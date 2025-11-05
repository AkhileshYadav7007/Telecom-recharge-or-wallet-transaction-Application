package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.ThresholdProfile;
import com.recharge.RechargeServices.entity.ThresholdProfileDetails;

import java.util.List;

public interface ThresholdService {

    ThresholdProfile createThresholdProfile(ThresholdProfile thresholdProfile);

    ThresholdProfileDetails createThresholdProfileDetails(ThresholdProfileDetails thresholdProfileDetails);

    List<ThresholdProfile> getAllThresholdProfiles();

    List<ThresholdProfileDetails> getAllThresholdProfileDetails();

    boolean isThresholdExceeded(String userType, String groupId, long amount);
}
