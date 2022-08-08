package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cart Item Test")
class CartItemTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CartItem}
     *   <li>{@link CartItem#setCart(Cart)}
     *   <li>{@link CartItem#setId(Long)}
     *   <li>{@link CartItem#setProduct(Product)}
     *   <li>{@link CartItem#setQuantity(int)}
     *   <li>{@link CartItem#setUser(User)}
     *   <li>{@link CartItem#getCart()}
     *   <li>{@link CartItem#getId()}
     *   <li>{@link CartItem#getProduct()}
     *   <li>{@link CartItem#getQuantity()}
     *   <li>{@link CartItem#getUser()}
     * </ul>
     */
    @Test
    @DisplayName("Cart Item Getters and Setters")
    void testConstructor() {
        CartItem actualCartItem = new CartItem();

        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPaymentMethods(new ArrayList<>());
        user.setPhoneNumber("4105551212");

        Cart cart = new Cart();
        cart.setId(123L);
        cart.setTotal(BigDecimal.valueOf(42L));
        cart.setUser(user);

        actualCartItem.setCart(cart);
        actualCartItem.setId(123L);

        Product product = new Product();
        product.setCategory(Category.GENERAL);
        product.setDescription("The characteristics of someone or something");
        product.setId(123L);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setStock(1);
        product.updateStock(1);

        actualCartItem.setProduct(product);
        actualCartItem.setQuantity(1);

        User user1 = new User();
        user1.setAddressList(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPaymentMethods(new ArrayList<>());
        user1.setPhoneNumber("4105551212");

        actualCartItem.setUser(user1);

        assertSame(cart, actualCartItem.getCart());
        assertEquals(123L, actualCartItem.getId().longValue());
        assertSame(product, actualCartItem.getProduct());
        assertEquals(1, actualCartItem.getQuantity());
        assertSame(user1, actualCartItem.getUser());
    }
}

