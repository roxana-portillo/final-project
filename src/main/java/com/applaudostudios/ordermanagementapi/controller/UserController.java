package com.applaudostudios.ordermanagementapi.controller;

import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @GetMapping("/logout")
  public String logout(HttpServletRequest request) throws ServletException {
    request.logout();
    return "LOGGED OUT";
  }
}
