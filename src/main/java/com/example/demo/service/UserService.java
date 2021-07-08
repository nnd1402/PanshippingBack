package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;

public interface UserService {
	UserRegistrationDTO getUser(Long id);
	List<User> findAll();
	User save(User user);
	void delete(Long id);
}
