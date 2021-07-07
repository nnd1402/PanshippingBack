package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.controllers.UserController;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class PanShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanShippingApplication.class, args);
	}
}
