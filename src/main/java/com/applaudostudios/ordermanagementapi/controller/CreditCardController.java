package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.CreditCard;
import com.applaudostudios.ordermanagementapi.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/payments")
public class CreditCardController {
   private CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/all-cards")
  public ResponseEntity<List<CreditCard>> getAllCreditCards() {
    return ResponseEntity.ok().body(creditCardService.getAllPayments());
  }

  @PostMapping("/add-card")
  public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
    return ResponseEntity.ok().body(this.creditCardService.addPayment(creditCard));
  }

  @PutMapping("/update-card/{id}")
  public ResponseEntity<CreditCard> updateCreditCard(
      @PathVariable long id, @RequestBody CreditCard creditCard) {
    creditCard.setId(id);
    return ResponseEntity.accepted().body(this.creditCardService.updatePayment(creditCard));
  }

  @DeleteMapping("/remove-card/{id}")
  public HttpStatus deleteCreditCard(@PathVariable long id) {
    this.creditCardService.deletePayment(id);
    return HttpStatus.GONE;
  }
}
