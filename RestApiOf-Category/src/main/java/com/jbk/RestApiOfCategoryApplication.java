package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class RestApiOfCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiOfCategoryApplication.class, args);
		System.out.println("Welcome to Spring Boot...");
	}
	
	
	
}
