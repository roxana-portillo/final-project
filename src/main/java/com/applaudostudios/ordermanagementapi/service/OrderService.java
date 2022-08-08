package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(long id);

}
