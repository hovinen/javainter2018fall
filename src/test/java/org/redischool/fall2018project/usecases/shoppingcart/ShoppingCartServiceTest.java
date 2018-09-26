package org.redischool.fall2018project.usecases.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceTest {
    @Test
    void cartShouldBeInitiallyEmpty() {
        ShoppingCartService subject = new ShoppingCartService();

        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(), result.items());
    }
}