package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.CartItem;
import com.applaudostudios.ordermanagementapi.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/carts")
public class CartItemController {

  private CartItemService cartItemService;

  @Autowired
  public CartItemController(CartItemService cartItemService) {
    this.cartItemService = cartItemService;
  }

  @GetMapping("/all-items")
  public ResponseEntity<List<CartItem>> getAllCartItems() {
    return ResponseEntity.ok().body(cartItemService.getAllCartItems());
  }

  @PostMapping("/add-item")
  public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
    return ResponseEntity.ok().body(this.cartItemService.addCartItem(cartItem));
  }

  @PutMapping("/update-item/{id}")
  public ResponseEntity<CartItem> updateCartItem(
      @PathVariable long id, @RequestBody CartItem cartItem) {
    cartItem.setId(id);
    return ResponseEntity.accepted().body(this.cartItemService.updateCartItem(cartItem));
  }

  @DeleteMapping("/remove-item/{id}")
  public HttpStatus deleteCartItem(@PathVariable long id) {
    this.cartItemService.deleteCartItem(id);
    return HttpStatus.GONE;
  }
}
