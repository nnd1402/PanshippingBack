package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;

public interface UserService {
	UserRegistrationDTO getUser(Long id);
	List<UserRegistrationDTO> findAll();
	UserRegistrationDTO save(UserRegistrationDTO userDto);
	void delete(Long id);
}
