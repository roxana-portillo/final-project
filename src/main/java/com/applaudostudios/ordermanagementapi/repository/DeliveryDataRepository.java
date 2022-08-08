package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.DeliveryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDataRepository extends JpaRepository<DeliveryData, Long> {
}