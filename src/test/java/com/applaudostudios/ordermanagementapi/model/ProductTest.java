package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Product Model Tests")
class ProductTest {

    @Test
    @DisplayName("Should model product")
    void shouldReturnProduct() {
        Product actualProduct = new Product();

        actualProduct.setCategory(Category.GENERAL);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(123L);
        actualProduct.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualProduct.setPrice(valueOfResult);
        actualProduct.setStock(1);
        actualProduct.updateStock(1);

        assertEquals(Category.GENERAL, actualProduct.getCategory());
        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(123L, actualProduct.getId());
        assertEquals("Name", actualProduct.getName());
        assertSame(valueOfResult, actualProduct.getPrice());
        assertEquals(0, actualProduct.getStock());
    }
}

