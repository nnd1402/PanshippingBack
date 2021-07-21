package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserRegistrationDTO;

public interface UserService {
	UserRegistrationDTO getUser(Long id);

	List<UserRegistrationDTO> findAll();

	Boolean save(UserRegistrationDTO userDto);
	
	Boolean update(UserRegistrationDTO userDto);

	Boolean delete(Long id);

	UserRegistrationDTO loginUsername(UserLoginDTO userLoginDTO);
}
