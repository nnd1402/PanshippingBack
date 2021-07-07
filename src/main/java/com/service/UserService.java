package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	User findOne(int id);
	List<User> findAll();
	User save(User user);
	User delete(int id); 
}
