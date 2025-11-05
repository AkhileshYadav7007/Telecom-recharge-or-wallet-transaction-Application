package com.recharge.RechargeServices.service.impl;

import com.recharge.RechargeServices.entity.ProductProfile;
import com.recharge.RechargeServices.entity.ProductProfileId;
import com.recharge.RechargeServices.repository.ProductProfileRepository;
import com.recharge.RechargeServices.service.ProductProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductProfileServiceImpl implements ProductProfileService {

    @Autowired
    private ProductProfileRepository productProfileRepository;

    @Override
    public ProductProfile createProductProfile(ProductProfile productProfile) {
        return productProfileRepository.save(productProfile);
    }

    @Override
    public List<ProductProfile> getAllProductProfiles() {
        return productProfileRepository.findAll();
    }

    @Override
    public ProductProfile getProductProfileById(ProductProfileId id) {
        return productProfileRepository.findById(id).orElse(null);
    }
}
