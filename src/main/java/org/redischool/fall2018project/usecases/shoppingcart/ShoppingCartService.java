package org.redischool.fall2018project.usecases.shoppingcart;

public final class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCart getCurrentShoppingCart() {
        return shoppingCartRepository.fetchShoppingCart();
    }

    public void addToCurrentShoppingCart(Product product, int quantity) {
        ShoppingCart shoppingCart = shoppingCartRepository.fetchShoppingCart();
        shoppingCart.add(product, quantity);
        shoppingCartRepository.persistShoppingCart(shoppingCart);
    }
}
