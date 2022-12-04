package com.sojern.techtest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ImageControllerTest {

    private final String localUrl = "http://localhost:8080";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getImg() {

        ResponseEntity<byte[]> response = restTemplate.getForEntity(localUrl + "/img", byte[].class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
    }
}
