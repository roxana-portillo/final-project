package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.service.CustomerService;
import com.applaudostudios.ordermanagementapi.service.CustomerServiceImpl;

public class CustomerController {
  private CustomerService customerService = new CustomerServiceImpl();

  public void createCustomer(String email, String name) {
    customerService.createCustomer(email, name);
    System.out.println("Customer created");
  }
}
