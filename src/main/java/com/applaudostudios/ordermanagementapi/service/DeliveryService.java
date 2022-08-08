package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.DeliveryData;

public interface DeliveryService {
    DeliveryData createDelivery(DeliveryData delivery);

    DeliveryData getDeliveryById(long id);
}
