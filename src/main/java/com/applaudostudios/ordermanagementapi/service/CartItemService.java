package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemService {
    CartItem addCartItem(CartItem cartItem);
    CartItem updateCartItem(CartItem cartItem);
    List<CartItem> getAllCartItems();
    void deleteCartItem(long id);
}
