package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}