package com.applaudostudios.ordermanagementapi.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Object Not Found Exception Test")
class ObjectNotFoundExceptionTest {
    /**
     * Method under test: {@link ObjectNotFoundException#ObjectNotFoundException(Long)}
     */
    @Test
    @DisplayName("Object Not Found Exception")
    void testConstructor() {
        ObjectNotFoundException actualObjectNotFoundException = new ObjectNotFoundException(123L);
        assertNull(actualObjectNotFoundException.getCause());
        assertEquals(0, actualObjectNotFoundException.getSuppressed().length);
        assertEquals("Could not find object 123", actualObjectNotFoundException.getMessage());
        assertEquals("Could not find object 123", actualObjectNotFoundException.getLocalizedMessage());
    }
}

