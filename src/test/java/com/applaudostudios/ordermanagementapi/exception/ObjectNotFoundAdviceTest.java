package com.applaudostudios.ordermanagementapi.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Object Not Advice Test Found")
class ObjectNotFoundAdviceTest {
  @Test
  @DisplayName("Object Not Found")
  void testObjectNotFoundHandler() {
    ObjectNotFoundAdvice objectNotFoundAdvice = new ObjectNotFoundAdvice();
    assertEquals(
        "Could not find object 123",
        objectNotFoundAdvice.objectNotFoundHandler(new ObjectNotFoundException(123L)));
  }
}
