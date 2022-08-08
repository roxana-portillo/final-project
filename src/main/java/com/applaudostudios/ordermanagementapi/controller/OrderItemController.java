package com.applaudostudios.ordermanagementapi.controller;
import com.applaudostudios.ordermanagementapi.model.OrderItem;
import com.applaudostudios.ordermanagementapi.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @GetMapping("/find-orderitem/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable long id) {
        return ResponseEntity.ok().body(orderItemService.getOrderItemById(id));
    }

    @PostMapping("/add-orderitem")
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem item) {
        return ResponseEntity.ok().body(this.orderItemService.addOrderItem(item));
    }
}
