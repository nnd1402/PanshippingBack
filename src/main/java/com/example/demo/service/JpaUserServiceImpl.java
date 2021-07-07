package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class JpaUserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	 @Override
	 public Optional<User> findById(Long id) {

		 return userRepository.findById(id);
	}
	
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	
	

}
