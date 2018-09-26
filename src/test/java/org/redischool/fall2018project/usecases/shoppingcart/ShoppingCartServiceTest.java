package org.redischool.fall2018project.usecases.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceTest {
    private final ShoppingCartService subject = new ShoppingCartService();

    @Test
    void cartShouldBeInitiallyEmpty() {
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(), result.items());
    }

    @Test
    void cartShouldIncludeOneAddedItem() {
        Product product = new Product();
        int quantity = 3;

        subject.addToCurrentShoppingCart(product, quantity);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, quantity)), result.items());
    }
}