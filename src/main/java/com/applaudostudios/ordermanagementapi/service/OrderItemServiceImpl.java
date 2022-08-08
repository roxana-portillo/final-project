package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.OrderItem;
import com.applaudostudios.ordermanagementapi.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

  private OrderItemRepository orderItemRepository;

  @Autowired
  public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
    this.orderItemRepository = orderItemRepository;
  }

  @Override
  public OrderItem addOrderItem(OrderItem orderItem) {
    return orderItemRepository.save(orderItem);
  }

  @Override
  public OrderItem getOrderItemById(long id) {
    Optional<OrderItem> orderItem = this.orderItemRepository.findById(id);
    if (orderItem.isPresent()) {
      return orderItem.get();
    } else {
      throw new ResourceNotFoundException("Record not found with email : " + id);
    }
  }
}
