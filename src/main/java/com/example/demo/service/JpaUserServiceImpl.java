package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class ImplUserService implements UserService {

	private Map<Integer, User> users = new HashMap<>();
	private int nextId = 1;
	
	@Override
	public User findOne(int id) {
		return users.get(id);
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(users.values());
	}

	@Override
	public User save(User user) {
		if(user.getId() == 0) {
			user.setId(nextId);
			nextId += 1;
		}
		
		users.put(user.getId(), user);
		
		return user;
	}

	@Override
	public User delete(int id) {
		if(!users.containsKey(id)) {
			throw new IllegalArgumentException("Tried to"
					+ " remove non-existing user.");
		}
		
		return users.remove(id);
	}

}
