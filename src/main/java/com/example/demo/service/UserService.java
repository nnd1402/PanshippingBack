package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserRegistrationDTO;


public interface UserService {
	UserRegistrationDTO getUser(Long id);
	List<UserRegistrationDTO> findAll();
	UserRegistrationDTO save(UserRegistrationDTO userDto);

	Boolean delete(Long id);
	UserRegistrationDTO loginUsername(UserLoginDTO userLoginDTO);

}
