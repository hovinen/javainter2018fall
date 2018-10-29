package org.redischool.fall2018project.usecases.shoppingcart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ShoppingCartControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello, World!");
    }

    @Test
    void testTotalOfEmptyShoppingCartIsZero() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/shoppingcart/total",
                String.class)).contains("0.0");
    }

    @Test
    void testAddAProductToTheShoppingCart() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/shoppingcart/product?name=Banana&price=10.0",
                String.class)).contains("{product=Product{name=Banana}, quantity=1}");
    }

    @Test
    void testAddTwoProductsToTheShoppingCart() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "shoppingcart/product?name=Banana&quantity=2&price=10.0",
                String.class)).contains("{product=Product{name=Banana}, quantity=2}");
    }
}