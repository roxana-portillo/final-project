package com.applaudostudios.ordermanagementapi.repository;
import com.applaudostudios.ordermanagementapi.model.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("OrderItemItem Repository Tests")
class OrderItemRepositoryTest {

  @Autowired private OrderItemRepository orderItemRepository;

  private OrderItem orderItem;

  @BeforeEach
  void setUp() {
    orderItem = new OrderItem();
    orderItem.setId(1L);
    orderItem.setQuantity(1);
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates orderItem when successful")
  void save_CreateOrderItem_WhenSuccessful() {
    OrderItem savedOrderItem = this.orderItemRepository.save(orderItem);
    assertThat(savedOrderItem).isNotNull();
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns orderItem when successful")
  void givenOrderItemObject_whenFindById_thenReturnOrderItem() {
    Optional<OrderItem> foundOrderItem = this.orderItemRepository.findById(orderItem.getId());
    assertThat(foundOrderItem).isNotNull();
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns orderItem list when successful")
  void whenFindAll_thenReturnOrderItemList() {
    List<OrderItem> orderItems = this.orderItemRepository.findAll();
    assertThat(orderItems).size().isPositive();
  }
}
