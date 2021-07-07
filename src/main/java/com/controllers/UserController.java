package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.repository.UserRepository;

@RestController
@RequestMapping(path="/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/getAllUsers")
	public @ResponseBody Iterable<User> getAllUsers() {
	    return userRepository.findAll();
	}
}
