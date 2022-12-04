package com.sojern.techtest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PingControllerTest {

    private final String localUrl = "http://localhost:8080";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void pingServiceUnavailable() {
        ResponseEntity<String> response = restTemplate.getForEntity(localUrl + "/ping", String.class);
        assertTrue(response.getStatusCode().is5xxServerError());
        assertEquals("File Not Found", response.getBody());
    }
}
