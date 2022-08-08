package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Order Test")
class OrderTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Order}
     *   <li>{@link Order#setId(Long)}
     *   <li>{@link Order#setOrderItems(List)}
     *   <li>{@link Order#setStatus(Status)}
     *   <li>{@link Order#setTotal(BigDecimal)}
     *   <li>{@link Order#setUser(User)}
     *   <li>{@link Order#getDate()}
     *   <li>{@link Order#getId()}
     *   <li>{@link Order#getOrderItems()}
     *   <li>{@link Order#getStatus()}
     *   <li>{@link Order#getTotal()}
     *   <li>{@link Order#getUser()}
     * </ul>
     */
    @Test
    @DisplayName("Order  Getters and Setters")
    void testConstructor() {
        Order actualOrder = new Order();
        actualOrder.setId(123L);
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        actualOrder.setOrderItems(orderItemList);
        actualOrder.setStatus(Status.PROCESSING);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualOrder.setTotal(valueOfResult);

        User user = new User();
        ArrayList<Address> addressList = new ArrayList<>();
        user.setAddressList(addressList);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");

        ArrayList<CreditCard> creditCardList = new ArrayList<>();
        user.setPaymentMethods(creditCardList);
        user.setPhoneNumber("4105551212");
        actualOrder.setUser(user);

        assertEquals(123L, actualOrder.getId().longValue());
        List<OrderItem> orderItems = actualOrder.getOrderItems();
        assertSame(orderItemList, orderItems);
        assertEquals(Status.PROCESSING, actualOrder.getStatus());
        assertSame(valueOfResult, actualOrder.getTotal());
        assertSame(user, actualOrder.getUser());
    }
}

