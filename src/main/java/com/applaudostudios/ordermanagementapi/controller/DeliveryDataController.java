package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.DeliveryData;
import com.applaudostudios.ordermanagementapi.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/delivery")
public class DeliveryDataController {

  private DeliveryService deliveryService;

  @Autowired
  public DeliveryDataController(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }

  @GetMapping("/find-delivery/{id}")
  public ResponseEntity<DeliveryData> getDeliveryDataById(@PathVariable long id) {
    return ResponseEntity.ok().body(deliveryService.getDeliveryById(id));
  }

  @PostMapping("/create-delivery")
  public ResponseEntity<DeliveryData> createDeliveryData(@RequestBody DeliveryData delivery) {
    return ResponseEntity.ok().body(this.deliveryService.createDelivery(delivery));
  }
}
