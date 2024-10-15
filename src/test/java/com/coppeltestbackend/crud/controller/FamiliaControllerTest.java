package com.coppeltestbackend.crud.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FamiliaControllerTest {
    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Test
    void familiaTest() throws Exception {
        String file = new String(Files.readAllBytes(Paths.get("src/main/resources/JsonFormat/familias.json")));

        assertThat(this.restTemplate.getForObject("http://127.0.0.1:"+ port +"/familia/findAllFamilias",
                String.class)).contains(file);
    }
}