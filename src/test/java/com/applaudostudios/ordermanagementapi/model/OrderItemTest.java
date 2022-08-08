package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Order Item Test")
class OrderItemTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link OrderItem}
     *   <li>{@link OrderItem#setId(Long)}
     *   <li>{@link OrderItem#setItem(Product)}
     *   <li>{@link OrderItem#setOrder(Order)}
     *   <li>{@link OrderItem#setQuantity(int)}
     *   <li>{@link OrderItem#getId()}
     *   <li>{@link OrderItem#getItem()}
     *   <li>{@link OrderItem#getOrder()}
     *   <li>{@link OrderItem#getQuantity()}
     * </ul>
     */
    @Test
    @DisplayName("Order Item Getters and Setters")
    void testConstructor() {
        OrderItem actualOrderItem = new OrderItem();
        actualOrderItem.setId(123L);

        Product product = new Product();
        product.setCategory(Category.GENERAL);
        product.setDescription("The characteristics of someone or something");
        product.setId(123L);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setStock(1);
        product.updateStock(1);

        actualOrderItem.setItem(product);

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
        order.setTotal(BigDecimal.valueOf(42L));
        order.setUser(user);

        actualOrderItem.setOrder(order);
        actualOrderItem.setQuantity(1);

        assertEquals(123L, actualOrderItem.getId().longValue());
        assertSame(product, actualOrderItem.getItem());
        assertSame(order, actualOrderItem.getOrder());
        assertEquals(1, actualOrderItem.getQuantity());
    }
}

