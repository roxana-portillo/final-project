package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.Order;
import com.applaudostudios.ordermanagementapi.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Order Repository Tests")
class OrderRepositoryTest {

  @Autowired private OrderRepository orderRepository;

  private Order order;

  @BeforeEach
  void setUp() {
    order = new Order();
    order.setId(1L);
    order.setStatus(Status.PROCESSING);
    order.setTotal(BigDecimal.valueOf(25L));
  }

  @Test
  @Rollback(false)
  @org.junit.jupiter.api.Order(1)
  @DisplayName("Save creates order when successful")
  void save_CreateOrder_WhenSuccessful() {
    Order savedOrder = this.orderRepository.save(order);
    assertThat(savedOrder).isNotNull();
    assertThat(savedOrder.getId()).isEqualTo(order.getId());
  }

  @Test
  @org.junit.jupiter.api.Order(2)
  @DisplayName("Find by id returns order when successful")
  void givenOrderObject_whenFindById_thenReturnOrder() {
    Optional<Order> foundOrder = this.orderRepository.findById(order.getId());
    assertThat(foundOrder).isNotNull();
  }

  @Test
  @org.junit.jupiter.api.Order(3)
  @DisplayName("Find All returns order list when successful")
  void whenFindAll_thenReturnOrderList() {
    List<Order> orders = this.orderRepository.findAll();
    assertThat(orders).size().isPositive();
  }
}
