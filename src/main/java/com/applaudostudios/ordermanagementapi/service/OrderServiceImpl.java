package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.Order;
import com.applaudostudios.ordermanagementapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
            return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new ResourceNotFoundException("Record not found with email : " + id);
        }
    }

}
