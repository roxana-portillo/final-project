package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.Order;
import com.applaudostudios.ordermanagementapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

  private OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/find-order/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
    return ResponseEntity.ok().body(orderService.getOrderById(orderId));
  }

  @PostMapping("/create-order")
  public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    return ResponseEntity.ok().body(this.orderService.createOrder(order));
  }

}
