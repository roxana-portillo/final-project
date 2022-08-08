package com.applaudostudios.ordermanagementapi.exception;

public class ObjectNotFoundException extends RuntimeException {

  ObjectNotFoundException(Long id) {
    super("Could not find object " + id);
  }
}
