package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.CartItem;
import com.applaudostudios.ordermanagementapi.service.CartItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CartItemController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CartItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private CartItem cartItem;

    @MockBean
    CartItemService cartItemService;

    @BeforeEach
    void setUp() {
        cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setQuantity(1);
    }

    @Test
    void whenFindAll_thenReturnCartItemList() throws Exception {
        List<CartItem> allCartItem = Arrays.asList(cartItem);

        when(cartItemService.getAllCartItems()).thenReturn(allCartItem);

        mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/v1/carts/all-items")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(status().isOk());

        verify(cartItemService).getAllCartItems();
    }

    @Test
    void saveCartItem_WhenSuccessful() throws Exception {
        when(cartItemService.addCartItem(any(CartItem.class))).thenReturn(cartItem);

        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/v1/carts/add-item")
                                .content(new ObjectMapper().writeValueAsString(cartItem))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(cartItem.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(cartItem.getQuantity()))
                .andExpect(status().isOk());
    }

    @Test
    void save_UpdateCartItem_WhenSuccessful() throws Exception {
        cartItem.setQuantity(2);
        when(cartItemService.updateCartItem(any(CartItem.class))).thenReturn(cartItem);
        mockMvc
                .perform(
                        put("/v1/carts/update-item/1")
                                .content(new ObjectMapper().writeValueAsString(cartItem))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(cartItem.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(cartItem.getQuantity()))
                .andExpect(status().isAccepted());
    }

    @Test
    void delete_RemoveCartItem_WhenSuccessful() throws Exception {
        doNothing().when(cartItemService).deleteCartItem(anyLong());

        mockMvc
                .perform(MockMvcRequestBuilders.delete("/v1/carts/remove-item/1"))
                .andExpect(status().isOk());
        verify(cartItemService).deleteCartItem(anyLong());
    }
}