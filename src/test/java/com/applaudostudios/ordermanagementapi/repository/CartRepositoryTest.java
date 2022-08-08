package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Cart Repository Tests")
class CartRepositoryTest {

  @Autowired private CartRepository cartRepository;

  private Cart cart;

  @BeforeEach
  void setUp() {
    cart = new Cart();
    cart.setId(1L);
    cart.setTotal((BigDecimal.valueOf(10L)));
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates Cart when successful")
  void save_CreateCart_WhenSuccessful() {
    Cart savedCart = this.cartRepository.save(cart);
    assertThat(savedCart).isNotNull();
    assertThat(savedCart.getId()).isEqualTo(cart.getId());
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns Cart when successful")
  void givenCartObject_whenFindById_thenReturnCart() {
    Optional<Cart> foundCart = this.cartRepository.findById(cart.getId());
    assertThat(foundCart).isNotNull();
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns Cart list when successful")
  void whenFindAll_thenReturnCartList() {
    List<Cart> cart = this.cartRepository.findAll();
    assertThat(cart).size().isPositive();
  }
}
