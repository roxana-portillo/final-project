package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.Cart;
import com.applaudostudios.ordermanagementapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

  private CartRepository cartRepository;

  @Autowired
  public CartServiceImpl(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public Cart updateCart(Cart cart) {
    Optional<Cart> cartUpdate = this.cartRepository.findById(cart.getId());
    if (cartUpdate.isPresent()) {
      cartUpdate.get().setTotal(cart.getTotal());
      cartRepository.save(cartUpdate.get());
      return cartUpdate.get();
    } else {
      throw new ResourceNotFoundException("Record not found with id : " + cart.getId());
    }
  }

  @Override
  public Cart getCartById(long id) {
    Optional<Cart> cart = this.cartRepository.findById(id);
    if (cart.isPresent()) {
      return cart.get();
    } else {
      throw new ResourceNotFoundException("Record not found with email : " + id);
    }
  }
}
