package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.Address;
import com.applaudostudios.ordermanagementapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/address")
public class AddressController {

  private AddressService addressService;

  @Autowired
  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping("/all-address")
  public ResponseEntity<List<Address>> getAllAddresses() {
    return ResponseEntity.ok().body(addressService.getAllAddress());
  }

  @PostMapping("/add-address")
  public ResponseEntity<Address> createAddress(@RequestBody Address address) {
    return ResponseEntity.ok().body(this.addressService.addAddress(address));
  }

  @PutMapping("/update-address/{id}")
  public ResponseEntity<Address> updateAddress(
      @PathVariable long id, @RequestBody Address address) {
    address.setId(id);
    return ResponseEntity.accepted().body(this.addressService.updateAddress(address));
  }

  @DeleteMapping("/remove-item/{id}")
  public HttpStatus deleteAddress(@PathVariable long id) {
    this.addressService.deleteAddress(id);
    return HttpStatus.GONE;
  }
}
