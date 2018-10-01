package org.redischool.fall2018project.usecases.shoppingcart;

public interface ShoppingCartRepository {
    void persistShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart fetchShoppingCart();
}
