package com.applaudostudios.ordermanagementapi.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Resource Not Found Test")
class ResourceNotFoundExceptionTest {

  String message;

  @BeforeEach
  void setUp() {
    message = "User not found";
  }

  @Test
  @DisplayName("Resource Not Found Return Message")
  void whenResourceNotFound_thenReturnMessage() {
    ResourceNotFoundException exception = new ResourceNotFoundException(message);
    assertEquals(message, exception.getMessage());
  }
}
