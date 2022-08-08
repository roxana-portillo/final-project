package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Delivery Data Test")
class DeliveryDataTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link DeliveryData}
     *   <li>{@link DeliveryData#setAddress(Address)}
     *   <li>{@link DeliveryData#setId(Long)}
     *   <li>{@link DeliveryData#setOrder(Order)}
     *   <li>{@link DeliveryData#setStatus(Status)}
     *   <li>{@link DeliveryData#setTrackNumber(String)}
     *   <li>{@link DeliveryData#getAddress()}
     *   <li>{@link DeliveryData#getId()}
     *   <li>{@link DeliveryData#getOrder()}
     *   <li>{@link DeliveryData#getStatus()}
     *   <li>{@link DeliveryData#getTrackNumber()}
     * </ul>
     */
    @Test
    @DisplayName("Delivery Data Getters and Setters")
    void testConstructor() {
        DeliveryData actualDeliveryData = new DeliveryData();

        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPaymentMethods(new ArrayList<>());
        user.setPhoneNumber("4105551212");

        Address address = new Address();
        address.setAddress1("42 Main St");
        address.setAddress2("42 Main St");
        address.setCity(new City());
        address.setCountry(new Country());
        address.setId(123L);
        address.setState(new State());
        address.setUser(user);

        actualDeliveryData.setAddress(address);
        actualDeliveryData.setId(123L);

        User user1 = new User();
        user1.setAddressList(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPaymentMethods(new ArrayList<>());
        user1.setPhoneNumber("4105551212");

        Order order = new Order();
        order.setId(123L);
        order.setOrderItems(new ArrayList<>());
        order.setStatus(Status.PROCESSING);
        order.setTotal(BigDecimal.valueOf(42L));
        order.setUser(user1);

        actualDeliveryData.setOrder(order);
        actualDeliveryData.setStatus(Status.PROCESSING);
        actualDeliveryData.setTrackNumber("42");

        assertSame(address, actualDeliveryData.getAddress());
        assertEquals(123L, actualDeliveryData.getId().longValue());
        assertSame(order, actualDeliveryData.getOrder());
        assertEquals(Status.PROCESSING, actualDeliveryData.getStatus());
        assertEquals("42", actualDeliveryData.getTrackNumber());
    }
}

