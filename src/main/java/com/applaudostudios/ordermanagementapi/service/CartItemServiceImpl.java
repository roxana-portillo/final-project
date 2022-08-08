package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.CartItem;
import com.applaudostudios.ordermanagementapi.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

  private CartItemRepository cartItemRepository;

  @Autowired
  public CartItemServiceImpl(CartItemRepository cartItemRepository) {
    this.cartItemRepository = cartItemRepository;
  }

  @Override
  public CartItem addCartItem(CartItem cartItem) {
    if (cartItem.getProduct().getStock() >= 1) {
      return cartItemRepository.save(cartItem);
    } else {
      throw new ResourceNotFoundException("Record not found with id : " + cartItem.getId());
    }
  }

  @Override
  public CartItem updateCartItem(CartItem cartItem) {
    Optional<CartItem> cartItemUpdate = this.cartItemRepository.findById(cartItem.getId());
    if (cartItemUpdate.isPresent()) {
      cartItemUpdate.get().setQuantity(cartItem.getQuantity());
      cartItemRepository.save(cartItemUpdate.get());
      return cartItemUpdate.get();
    } else {
      throw new ResourceNotFoundException("Record not found with id : " + cartItem.getId());
    }
  }

  @Override
  public List<CartItem> getAllCartItems() {
    return this.cartItemRepository.findAll();
  }

  @Override
  public void deleteCartItem(long id) {
    this.cartItemRepository.deleteById(id);
  }
}
