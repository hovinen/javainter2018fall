package org.redischool.fall2018project.usecases.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.List;

//import static org.junit.Assert.assertEquals;
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
        Product product = new Product("Product", 10.0);
        int quantity = 3;

        subject.addToCurrentShoppingCart(product, quantity);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, quantity)), result.items());
    }

    @Test
    void cartShouldConsolidateItemsWithTheSameProduct() {
        Product product = new Product("Product", 10.0);

        subject.addToCurrentShoppingCart(product, 1);
        subject.addToCurrentShoppingCart(product, 2);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, 3)), result.items());
    }

    @Test
    void cartShouldAllowAddingTwoDifferentProducts() {
        Product product1 = new Product("Apple", 10.0);
        Product product2 = new Product("Orange", 10.0);

        subject.addToCurrentShoppingCart(product1, 1);
        subject.addToCurrentShoppingCart(product2, 1);
        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product1, 1), new ShoppingCart.Item(product2, 1)), result.items());
    }

    @Test
    void serviceShouldRetrieveShoppingCartFromRepository() {
        Product product = new Product("Product", 10.0);
        shoppingCartRepository.persistShoppingCart(new ShoppingCart().add(product, 1));

        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(List.of(new ShoppingCart.Item(product, 1)), result.items());
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
<<<<<<< HEAD
    void serviceShouldComputeTotalOfCartWith2Items(){
        Product product1 = new Product("Apple",15.7);
        Product product2 = new Product ("banana", 10.00);
        subject.addToCurrentShoppingCart(product1, 1);

        subject.addToCurrentShoppingCart(product2, 1);
        ShoppingCart result = subject.getCurrentShoppingCart();
        assertEquals(25.7, result.total());


    }


}
=======
        void serviceShouldComputeTotalPrice(){
        Product product1 = new Product("apple", 10.00);
        subject.addToCurrentShoppingCart(product1, 3);
        Product product2 = new Product ( "banana", 15.00);
        subject.addToCurrentShoppingCart(product2,2);

        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(50.00, result.total());
    }

    @Test
    void serviceShouldComputeTotalPriceWithDiscount(){
        Product product1 = new Product("apple", 10.00);
        subject.addToCurrentShoppingCart(product1, 9);

        ShoppingCart result = subject.getCurrentShoppingCart();

        assertEquals(80.00, result.total());
    }

    }
>>>>>>> 13ed8cbdc4fa40f252a117425b320e11a685e2fc
