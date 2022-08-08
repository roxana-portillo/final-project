package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cart Test")
class CartTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Cart}
     *   <li>{@link Cart#setId(long)}
     *   <li>{@link Cart#setTotal(BigDecimal)}
     *   <li>{@link Cart#setUser(User)}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getTotal()}
     *   <li>{@link Cart#getUser()}
     * </ul>
     */
    @Test
    @DisplayName("Cart Item Getter and Setter")
    void testConstructor() {
        Cart actualCart = new Cart();
        actualCart.setId(123L);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualCart.setTotal(valueOfResult);

        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPaymentMethods(new ArrayList<>());
        user.setPhoneNumber("4105551212");

        actualCart.setUser(user);

        assertEquals(123L, actualCart.getId());
        assertSame(valueOfResult, actualCart.getTotal());
        assertSame(user, actualCart.getUser());
    }
}

