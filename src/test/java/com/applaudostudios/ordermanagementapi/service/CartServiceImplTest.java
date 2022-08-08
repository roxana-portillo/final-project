package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.Cart;
import com.applaudostudios.ordermanagementapi.repository.CartRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class CartServiceImplTest {

  @Mock private CartRepository cartRepository;

  @InjectMocks private CartServiceImpl cartService;
  private Cart cart;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    cart = new Cart();
    cart.setId(1L);
    cart.setTotal((BigDecimal.valueOf(10L)));
  }

  @Test
  @DisplayName("Get Cart By Id")
  void givenId_ThenShouldReturnProductOfThatId() {
    when(cartRepository.findById(1L)).thenReturn(Optional.ofNullable(cart));
    AssertionsForClassTypes.assertThat(cartService.getCartById(cart.getId())).isNotNull();
    verify(cartRepository, times(1)).findById(anyLong());
  }

  @Test
  @DisplayName("Update Cart")
  void givenCartObject_whenUpdateCart_thenReturnUpdatedCart() {
    when(cartRepository.save(cart)).thenReturn(any(Cart.class));
    cart.setTotal(BigDecimal.valueOf(20L));
    assertThatExceptionOfType(ResourceNotFoundException.class)
        .isThrownBy(() -> cartService.updateCart(cart));
  }
}
