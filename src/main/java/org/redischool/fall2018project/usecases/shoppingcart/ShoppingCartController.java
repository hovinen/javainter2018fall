package org.redischool.fall2018project.usecases.shoppingcart;

import org.springframework.web.bind.annotation.*;

@RestController
public final class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository = new LocalFileShoppingCartRepository();
    private final ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);

    @RequestMapping("/shoppingcart/total")
    public String total() {
        return String.valueOf(shoppingCartService.getCurrentShoppingCart().total());
    }

    @RequestMapping(path = "/shoppingcart/product", method = RequestMethod.POST)
    public ShoppingCartDto addProductToCart(@RequestBody ItemDto itemDto) {
        Product product = new Product(itemDto.getName(), itemDto.getPrice());

        shoppingCartService.addToCurrentShoppingCart(product, itemDto.getQuantity());

        return ShoppingCartDto.of(shoppingCartService.getCurrentShoppingCart());
    }

    @RequestMapping(path = "/shoppingcart/product", method = RequestMethod.PUT)
    public void modifyProduct(@RequestBody ItemDto itemDto) {
        Product product = new Product(itemDto.getName(), itemDto.getPrice());

        shoppingCartService.setQuantityOfProductInCurrentShoppingCart(product, itemDto.getQuantity());
    }

    @RequestMapping("/shoppingcart/")
    public ShoppingCartDto getShoppingCart() {
        return ShoppingCartDto.of(shoppingCartService.getCurrentShoppingCart());
    }

    @RequestMapping(path = "/shoppingcart/", method = RequestMethod.DELETE)
    public void deleteShoppingCart() {
        shoppingCartService.clear();
    }

}
