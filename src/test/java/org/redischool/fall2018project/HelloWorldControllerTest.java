package org.redischool.fall2018project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetingEndpointShouldReturnHelloWorld(){
        String result = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);

        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void greetingEndpointShouldReturnHelloAnna(){
        String result = this.restTemplate.getForObject("http://localhost:" + port + "/?name=Anna", String.class);

        assertThat(result).isEqualTo("Hello, Anna");
    }

}
