package org.redischool.fall2018project.usecases.foundationpicker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class FoundationPickerControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void lightFoundationForLigtSkin() {

        ResponseEntity<Foundation> entity = this.restTemplate.getForEntity("http://localhost:" + port + "/foundation?typeOfSkin=Light&skinConsistency=OILY",
                Foundation.class);
        assertThat(entity.getBody()).isEqualTo(Foundation.LightOily);
    }
}
