package org.redischool.fall2018project.usecases.shoppingcart;

public final class ShoppingCartService {
    private final ShoppingCart shoppingCart = new ShoppingCart();

    public ShoppingCart getCurrentShoppingCart() {
        return shoppingCart;
    }

    public void addToCurrentShoppingCart(Product product, int quantity) {
        if (shoppingCart.items().isEmpty()) {
            shoppingCart.addItem(new ShoppingCart.Item(product, quantity));
        } else {
            shoppingCart.addToItem(quantity);
        }
    }
}
