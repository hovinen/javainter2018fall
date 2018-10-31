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
    public ProductDto addProductToCart(@RequestParam String name,
                                   @RequestParam double price,
                                   @RequestParam(value = "quantity", defaultValue = "1") int quantity) {
        Product product = new Product(name, price);

        shoppingCartService.addToCurrentShoppingCart(product, quantity);

        return product.toProductDto();
    }

    @RequestMapping("/shoppingcart/")
    public String getShoppingCart(){
        return String.valueOf(shoppingCartService.getCurrentShoppingCart());
    }

}
