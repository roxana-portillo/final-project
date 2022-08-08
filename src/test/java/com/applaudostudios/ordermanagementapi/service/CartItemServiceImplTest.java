package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.CartItem;
import com.applaudostudios.ordermanagementapi.repository.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartItemServiceImplTest {

  @Mock private CartItemRepository cartItemRepository;

  @InjectMocks private CartItemServiceImpl cartItemService;
  private CartItem cartItem;
  List<CartItem> cartItemList;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    cartItemList = new ArrayList<>();
    cartItem = new CartItem();
    cartItem.setId(1L);
    cartItem.setQuantity(1);
    cartItemList.add(cartItem);
  }

  @Test
  @DisplayName("Update CartItem")
  void givenCartItemObject_whenUpdateCartItem_thenReturnUpdatedCartItem() {
    when(cartItemRepository.save(cartItem)).thenReturn(any(CartItem.class));
    cartItem.setQuantity(2);
    assertThatExceptionOfType(ResourceNotFoundException.class)
        .isThrownBy(() -> cartItemService.updateCartItem(cartItem));
  }

  @Test
  @DisplayName("Get CartItem List")
  void allCartItem_ShouldReturnListOfAllCartItem() {
    cartItemRepository.save(cartItem);
    when(cartItemRepository.findAll()).thenReturn(cartItemList);
    List<CartItem> cartItemList1 = cartItemService.getAllCartItems();
    assertThat(cartItemList1).isEqualTo(cartItemList);
    verify(cartItemRepository, times(1)).save(cartItem);
    verify(cartItemRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Delete CartItem")
  void givenId_ThenShouldDeleteTheCartItemOfThatId() {
    doNothing().when(cartItemRepository).deleteById(1L);
    cartItemService.deleteCartItem(1L);
    verify(cartItemRepository, times(1)).deleteById(1L);
  }
}
