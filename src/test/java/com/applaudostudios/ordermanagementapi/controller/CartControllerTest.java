package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.Cart;
import com.applaudostudios.ordermanagementapi.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.math.BigDecimal;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CartController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CartControllerTest {

  @Autowired private MockMvc mockMvc;

  private Cart cart;

  @MockBean CartService cartService;

  @BeforeEach
  void setUp() {
    cart = new Cart();
    cart.setId(1L);
    cart.setTotal((BigDecimal.valueOf(10L)));
  }

  @Test
  @DisplayName("Find Cart By Id")
  void whenFindById_thenReturnCart() throws Exception {
    when(cartService.getCartById(anyLong())).thenReturn(any());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/carts/find-cart/1")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

    verify(cartService).getCartById(anyLong());
  }

  @Test
  void save_UpdateCart_WhenSuccessful() throws Exception {
    cart.setTotal((BigDecimal.valueOf(20L)));
    when(cartService.updateCart(any(Cart.class))).thenReturn(cart);
    mockMvc
        .perform(
            put("/v1/carts/update-cart/1")
                .content(new ObjectMapper().writeValueAsString(cart))
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(cart.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(cart.getTotal()))
        .andExpect(status().isAccepted());
  }
}
