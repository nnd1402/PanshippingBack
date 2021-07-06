package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping(value = "/getAllUsers")
	public String getUsers() {
		return "Hello users";
	}
}
