package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApiOfProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiOfProductApplication.class, args);
		System.out.println("Welcome to Spring Boot...");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
