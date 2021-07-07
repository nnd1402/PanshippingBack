package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	Optional<User> findById(Long id);
	List<User> findAll();
	User save(User user);
	void delete(Long id);
	
}
