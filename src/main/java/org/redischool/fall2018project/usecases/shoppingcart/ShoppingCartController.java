package org.redischool.fall2018project.usecases.shoppingcart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository = new FakeShoppingCartRepository();
    private final ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);

    @RequestMapping("/shoppingcart/total")
    public String total() {
        return String.valueOf(shoppingCartService.getCurrentShoppingCart().total());
    }

    @RequestMapping("/shoppingcart/product")
    public String addProductToCart(@RequestParam String name,
                                   @RequestParam double price,
                                   @RequestParam(value = "quantity", defaultValue = "1") int quantity) {
        shoppingCartService.addToCurrentShoppingCart(new Product(name, price), quantity);
        return shoppingCartService.getCurrentShoppingCart().items().toString();
    }
}
