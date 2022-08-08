package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart updateCart(Cart cart);

    Cart getCartById(long id);
}
