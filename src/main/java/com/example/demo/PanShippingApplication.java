package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.controllers.UserController;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class PanShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanShippingApplication.class, args);
	}

}
