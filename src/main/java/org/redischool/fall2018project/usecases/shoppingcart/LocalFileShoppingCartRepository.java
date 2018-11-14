package org.redischool.fall2018project.usecases.shoppingcart;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LocalFileShoppingCartRepository implements ShoppingCartRepository {

    @Override
    public void persistShoppingCart(ShoppingCart shoppingCart) {
        writeShoppingCartToFile(shoppingCart);
    }

    @Override
    public ShoppingCart fetchShoppingCart() {
        return readShoppingCartFromFile();
    }

    private ShoppingCart readShoppingCartFromFile() {
        try {
            ShoppingCartDto shoppingCartDto = new ObjectMapper().readValue(new File("shoppingCart.json"), ShoppingCartDto.class);
            return shoppingCartDto.toShoppingCart();
        } catch (IOException e) {
            return new ShoppingCart();
        }
    }

    private void writeShoppingCartToFile(ShoppingCart shoppingCart) {
        try {
            ShoppingCartDto shoppingCartDto = ShoppingCartDto.of(shoppingCart);
            new ObjectMapper().writeValue(new File("shoppingCart.json"), shoppingCartDto);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
