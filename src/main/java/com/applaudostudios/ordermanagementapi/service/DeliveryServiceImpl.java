package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.DeliveryData;
import com.applaudostudios.ordermanagementapi.repository.DeliveryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    private DeliveryDataRepository deliveryDataRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryDataRepository deliveryDataRepository) {
        this.deliveryDataRepository = deliveryDataRepository;
    }

    @Override
  public DeliveryData createDelivery(DeliveryData delivery) {
    return deliveryDataRepository.save(delivery);
  }

  @Override
  public DeliveryData getDeliveryById(long id) {
    Optional<DeliveryData> deliveryData = this.deliveryDataRepository.findById(id);
    if (deliveryData.isPresent()) {
      return deliveryData.get();
    } else {
      throw new ResourceNotFoundException("Record not found with email : " + id);
    }
  }
}
