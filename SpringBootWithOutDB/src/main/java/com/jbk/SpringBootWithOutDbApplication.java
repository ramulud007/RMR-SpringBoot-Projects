package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithOutDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithOutDbApplication.class, args);
		System.out.println("WelCome...");  
	}

}
