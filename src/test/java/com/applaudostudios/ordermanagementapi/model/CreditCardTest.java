package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Credit Card Test")
class CreditCardTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CreditCard}
     *   <li>{@link CreditCard#setBalance(double)}
     *   <li>{@link CreditCard#setCvv(String)}
     *   <li>{@link CreditCard#setExpDate(Date)}
     *   <li>{@link CreditCard#setId(Long)}
     *   <li>{@link CreditCard#setNumber(String)}
     *   <li>{@link CreditCard#setUser(User)}
     *   <li>{@link CreditCard#getBalance()}
     *   <li>{@link CreditCard#getCvv()}
     *   <li>{@link CreditCard#getExpDate()}
     *   <li>{@link CreditCard#getId()}
     *   <li>{@link CreditCard#getNumber()}
     *   <li>{@link CreditCard#getUser()}
     * </ul>
     */
    @Test
    @DisplayName("Credit Card Getter and Setters")
    void testConstructor() {
        CreditCard actualCreditCard = new CreditCard();
        actualCreditCard.setBalance(10.0d);
        actualCreditCard.setCvv("Cvv");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualCreditCard.setExpDate(fromResult);
        actualCreditCard.setId(123L);
        actualCreditCard.setNumber("42");

        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPaymentMethods(new ArrayList<>());
        user.setPhoneNumber("4105551212");

        actualCreditCard.setUser(user);

        assertEquals(10.0d, actualCreditCard.getBalance());
        assertEquals("Cvv", actualCreditCard.getCvv());
        assertSame(fromResult, actualCreditCard.getExpDate());
        assertEquals(123L, actualCreditCard.getId().longValue());
        assertEquals("42", actualCreditCard.getNumber());
        assertSame(user, actualCreditCard.getUser());
    }
}

