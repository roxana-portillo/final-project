package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Payment Details Test")
class PaymentDetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PaymentDetails}
     *   <li>{@link PaymentDetails#setAmount(BigDecimal)}
     *   <li>{@link PaymentDetails#setId(long)}
     *   <li>{@link PaymentDetails#setOrder(Order)}
     *   <li>{@link PaymentDetails#setStatus(Status)}
     *   <li>{@link PaymentDetails#getAmount()}
     *   <li>{@link PaymentDetails#getDate()}
     *   <li>{@link PaymentDetails#getId()}
     *   <li>{@link PaymentDetails#getOrder()}
     *   <li>{@link PaymentDetails#getStatus()}
     * </ul>
     */
    @Test
    @DisplayName("Payment Details Getters and Setters")
    void testConstructor() {
        PaymentDetails actualPaymentDetails = new PaymentDetails();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualPaymentDetails.setAmount(valueOfResult);
        actualPaymentDetails.setId(123L);

        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPaymentMethods(new ArrayList<>());
        user.setPhoneNumber("4105551212");

        Order order = new Order();
        order.setId(123L);
        order.setOrderItems(new ArrayList<>());
        order.setStatus(Status.PROCESSING);
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        order.setTotal(valueOfResult1);
        order.setUser(user);

        actualPaymentDetails.setOrder(order);
        actualPaymentDetails.setStatus(Status.PROCESSING);
        BigDecimal amount = actualPaymentDetails.getAmount();

        assertSame(valueOfResult, amount);
        assertEquals(valueOfResult1, amount);
        assertEquals(123L, actualPaymentDetails.getId());
        assertSame(order, actualPaymentDetails.getOrder());
        assertEquals(Status.PROCESSING, actualPaymentDetails.getStatus());
    }
}

