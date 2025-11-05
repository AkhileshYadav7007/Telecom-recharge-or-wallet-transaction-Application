package com.recharge.RechargeServices.repository;

import com.recharge.RechargeServices.entity.ProductProfile;
import com.recharge.RechargeServices.entity.ProductProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductProfileRepository extends JpaRepository<ProductProfile, ProductProfileId> {
    Optional<ProductProfile> findByProductId(String productId);
}
