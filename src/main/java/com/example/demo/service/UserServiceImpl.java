package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserRegistrationDTO getUser(Long id) {
		Optional<User> userResponse = userRepository.findById(id);

		if (userResponse.isPresent()) {
			return new UserRegistrationDTO(userResponse.get());
		}
		return null;
	}

	@Override
	public List<UserRegistrationDTO> findAll() {
		List<UserRegistrationDTO> result = new ArrayList<>();
		List<User> users = userRepository.findAll();

		for (User user : users) {
			result.add(new UserRegistrationDTO(user));
		}
		return result;
	}

	@Override
	public Boolean save(UserRegistrationDTO userDto) {
		User user = new User(userDto);
		userRepository.save(user);
		return true;
	}

	public Boolean update(UserRegistrationDTO userDto) {
		User user = new User(userDto);
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public UserRegistrationDTO loginUsername(UserLoginDTO userLoginDto) {
		User databaseUser = userRepository.findByUsername(userLoginDto.getUsername());
		if (databaseUser != null) {
			if (userLoginDto.getPassword().equals(databaseUser.getPassword())) {
				databaseUser.setPassword(null);
				return new UserRegistrationDTO(databaseUser);
			}
		}
		return null;
	}
}
