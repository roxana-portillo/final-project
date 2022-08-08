package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("CartItem Repository Tests")
class CartItemRepositoryTest {

  @Autowired private CartItemRepository cartItemRepository;

  private CartItem cartItem;

  @BeforeEach
  void setUp() {
    cartItem = new CartItem();
    cartItem.setId(1L);
    cartItem.setQuantity(1);
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates user when successful")
  void save_CreateUser_WhenSuccessful() {
    CartItem savedUser = this.cartItemRepository.save(cartItem);
    assertThat(savedUser).isNotNull();
    assertThat(savedUser.getId()).isEqualTo(cartItem.getId());
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns CartItem when successful")
  void givenCartItemObject_whenFindById_thenReturnCartItem() {
    Optional<CartItem> foundUser = this.cartItemRepository.findById(cartItem.getId());
    assertThat(foundUser).isNotNull();
    assertThat(foundUser.get().getId()).isEqualTo(cartItem.getId());
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns CartItem list when successful")
  void whenFindAll_thenReturnCartItemList() {
    List<CartItem> cartItems = this.cartItemRepository.findAll();
    assertThat(cartItems).size().isPositive();
  }
}
