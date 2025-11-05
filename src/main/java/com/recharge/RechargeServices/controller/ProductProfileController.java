package com.recharge.RechargeServices.controller;

import com.recharge.RechargeServices.entity.ProductProfile;
import com.recharge.RechargeServices.entity.ProductProfileId;
import com.recharge.RechargeServices.service.ProductProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductProfileController {

    @Autowired
    private ProductProfileService productProfileService;

    @PostMapping
    public ProductProfile createProductProfile(@RequestBody ProductProfile productProfile) {
        return productProfileService.createProductProfile(productProfile);
    }

    @GetMapping
    public List<ProductProfile> getAllProductProfiles() {
        return productProfileService.getAllProductProfiles();
    }

    @GetMapping("/get")
    public ProductProfile getProductProfileById(@RequestBody ProductProfileId id) {
        return productProfileService.getProductProfileById(id);
    }
}
