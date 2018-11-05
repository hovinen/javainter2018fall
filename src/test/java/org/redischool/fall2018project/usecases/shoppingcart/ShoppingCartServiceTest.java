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

        assertEquals(List.of(), result.getItems());
    }

    @Test
    void cartShouldIncludeOneAddedItem() {
        Product product = new Product("Product", 10.0);
        int quantity = 3;

        subject.addToCurrentShoppingCart(product, quantity);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, quantity)), result.getItems());
    }

    @Test
    void cartShouldConsolidateItemsWithTheSameProduct() {
        Product product = new Product("Product", 10.0);

        subject.addToCurrentShoppingCart(product, 1);
        subject.addToCurrentShoppingCart(product, 2);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, 3)), result.getItems());
    }

    @Test
    void cartShouldAllowAddingTwoDifferentProducts() {
        Product product1 = new Product("Apple", 10.0);
        Product product2 = new Product("Orange", 10.0);

        subject.addToCurrentShoppingCart(product1, 1);
        subject.addToCurrentShoppingCart(product2, 1);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product1, 1), new ShoppingCart.Item(product2, 1)), result.getItems());
    }

    @Test
    void serviceShouldRetrieveShoppingCartFromRepository() {
        Product product = new Product("Product", 10.0);
        shoppingCartRepository.persistShoppingCart(new ShoppingCart().add(product, 1));

        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, 1)), result.getItems());
    }
    @Test
    void serviceShouldComputeTotalOfEmptyCartAsZero(){
        ShoppingCart result = subject.getCurrentShoppingCart();
        assertEquals(0.0, result.total());
    }

    @Test
    void serviceShouldComputeTotalOfCartWithOneItem(){
        Product product = new Product("Product", 10.0);
        subject.addToCurrentShoppingCart(product,1);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(10.0, result.total());

    }

    @Test
    void serviceShouldComputeTotalOfCartWith2Items(){
        Product product1 = new Product("Apple",15.7);
        Product product2 = new Product ("banana", 10.00);
        subject.addToCurrentShoppingCart(product1, 1);

        subject.addToCurrentShoppingCart(product2, 1);
        ShoppingCart result = subject.getCurrentShoppingCart();
        assertEquals(25.7, result.total());


    }


}
