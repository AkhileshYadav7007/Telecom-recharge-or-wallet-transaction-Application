package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.entity.ThresholdProfileDetails;
import com.recharge.RechargeServices.entity.ThresholdsProfile;
import com.recharge.RechargeServices.service.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
public class ThresholdController {

    @Autowired
    private ThresholdService thresholdService;

    @PostMapping("/profiles")
    public ThresholdsProfile createThresholdProfile(@RequestBody ThresholdsProfile thresholdProfile) {
        return thresholdService.createThresholdProfile(thresholdProfile);
    }

    @PostMapping("/details")
    public ThresholdProfileDetails createThresholdProfileDetails(@RequestBody ThresholdProfileDetails thresholdProfileDetails) {
        return thresholdService.createThresholdProfileDetails(thresholdProfileDetails);
    }

    @GetMapping("/profiles")
    public List<ThresholdsProfile> getAllThresholdProfiles() {
        return thresholdService.getAllThresholdProfiles();
    }

    @GetMapping("/details")
    public List<ThresholdProfileDetails> getAllThresholdProfileDetails() {
        return thresholdService.getAllThresholdProfileDetails();
    }
}
