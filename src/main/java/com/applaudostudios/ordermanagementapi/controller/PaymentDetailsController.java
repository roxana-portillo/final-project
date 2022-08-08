package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.PaymentDetails;
import com.applaudostudios.ordermanagementapi.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
public class PaymentDetailsController {

  private PaymentDetailsService paymentDetailsService;

  @Autowired
  public PaymentDetailsController(PaymentDetailsService paymentDetailsService) {
    this.paymentDetailsService = paymentDetailsService;
  }

  @GetMapping("/find-paymentdetails/{id}")
  public ResponseEntity<PaymentDetails> getPaymentDetailsById(@PathVariable long id) {
    return ResponseEntity.ok().body(this.paymentDetailsService.getPaymentDetailsById(id));
  }

  @PostMapping("/create-paymentdetails")
  public ResponseEntity<PaymentDetails> createPaymentDetails(
      @RequestBody PaymentDetails paymentDetails) {
    return ResponseEntity.ok()
        .body(this.paymentDetailsService.createPaymentDetails(paymentDetails));
  }
}
