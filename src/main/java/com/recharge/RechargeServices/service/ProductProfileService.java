package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.ProductProfile;
import com.recharge.RechargeServices.entity.ProductProfileId;

import java.util.List;

public interface ProductProfileService {

    ProductProfile createProductProfile(ProductProfile productProfile);

    List<ProductProfile> getAllProductProfiles();

    ProductProfile getProductProfileById(ProductProfileId id);
}
