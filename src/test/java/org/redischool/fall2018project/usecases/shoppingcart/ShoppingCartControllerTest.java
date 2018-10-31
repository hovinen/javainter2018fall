package org.redischool.fall2018project.usecases.shoppingcart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    void testOneAProductToTheShoppingCart() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/shoppingcart/product?name=Banana&price=10.0",
                ProductDto.class)).isEqualToComparingFieldByField(new Product("Banana", 10.0));
    }

    @Test
    void testAddTwoProductsToTheShoppingCart() {


        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://localhost:" + port +
                        "shoppingcart/product?name=Banana&quantity=2&price=10.0",
                String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(forEntity.getBody());

        ProductDto object = this.restTemplate.getForObject("http://localhost:" + port +
                        "shoppingcart/product?name=Banana&quantity=2&price=10.0",
                ProductDto.class);
        assertThat(object).isEqualToComparingFieldByField(new Product("Banana", 10.0));
    }
    @Test
    void testShouldToHasAEmptyShoppingCart(){
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://localhost:" + port +
                        "shoppingcart/",
                String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(forEntity.getBody());


    }
}