package com.eventosapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class EventosAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void statusCode() throws URISyntaxException {
		/*
		long expected = 3;
		long actual = 4;
		
		assertEquals(expected, actual, "The add method should add two numbers");
		*/
	
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:8080/");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue(), "The status code");
		// assertEquals(true, result.getBody().contains("employeeList"), "Test");
	}

}
