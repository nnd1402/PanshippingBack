package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	 @Override
	 public UserRegistrationDTO getUser(Long id ) {
			Optional<User> userResponse =  userRepository.findById(id);
			
			if (userResponse.isPresent()) {
				return  new UserRegistrationDTO(userResponse.get());
			} 
			
			return null;
		}
	
	@Override
	public List<UserRegistrationDTO> findAll() {
		List<UserRegistrationDTO> result = new ArrayList<>();
		List<User> users = userRepository.findAll();
		
		for(User user: users) {
			result.add(new UserRegistrationDTO(user));
		}
		return result;
	}

	@Override
	public UserRegistrationDTO save (UserRegistrationDTO userDto) {
		User user = new User(userDto);
		User databaseUser = userRepository.save(user);
		UserRegistrationDTO resultDto = new UserRegistrationDTO(databaseUser);
		return resultDto;
	}

	@Override
	public Boolean delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user != null){
			userRepository.deleteById(id);
			return true;
		}
		return true;
	}

}
