package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.Cart;
import com.applaudostudios.ordermanagementapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/find-cart/{cartId}")
  public ResponseEntity<Cart> getCartById(@PathVariable long cartId) {
    return ResponseEntity.ok().body(cartService.getCartById(cartId));
  }

  @PutMapping("/update-cart/{id}")
  public ResponseEntity<Cart> updateCart(@PathVariable long id, @Valid @RequestBody Cart cart) {
    cart.setId(id);
    return ResponseEntity.accepted().body(this.cartService.updateCart(cart));
  }
}
