package org.redischool.fall2018project.usecases.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceTest {
    private final ShoppingCartRepository shoppingCartRepository = new FakeShoppingCartRepository();
    private final ShoppingCartService subject = new ShoppingCartService(shoppingCartRepository);

    @Test
    void cartShouldBeInitiallyEmpty() {
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(), result.items());
    }

    @Test
    void cartShouldIncludeOneAddedItem() {
        Product product = new Product("Product");
        int quantity = 3;

        subject.addToCurrentShoppingCart(product, quantity);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, quantity)), result.items());
    }

    @Test
    void cartShouldConsolidateItemsWithTheSameProduct() {
        Product product = new Product("Product");

        subject.addToCurrentShoppingCart(product, 1);
        subject.addToCurrentShoppingCart(product, 2);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, 3)), result.items());
    }

    @Test
    void cartShouldAllowAddingTwoDifferentProducts() {
        Product product1 = new Product("Apple");
        Product product2 = new Product("Orange");

        subject.addToCurrentShoppingCart(product1, 1);
        subject.addToCurrentShoppingCart(product2, 1);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product1, 1), new ShoppingCart.Item(product2, 1)), result.items());
    }

    @Test
    void serviceShouldRetrieveShoppingCartFromRepository() {
        Product product = new Product("Product");
        shoppingCartRepository.persistShoppingCart(new ShoppingCart().add(product, 1));

        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, 1)), result.items());
    }
}
