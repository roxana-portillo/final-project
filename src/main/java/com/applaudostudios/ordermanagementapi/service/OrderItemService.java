package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public interface OrderItemService {
     OrderItem addOrderItem(OrderItem orderItem);

     OrderItem getOrderItemById(long id);
}
