package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//Get All Users
	@GetMapping(value = "/getAllUsers")
	public @ResponseBody Iterable<User> getAllUsers() {
	    return userRepository.findAll();
	}
	
	//Add User
	@PostMapping(value = "/addUsers")
	User newUser(@RequestBody User newUser) {
	    return userRepository.save(newUser);
	}
	
	//Get Single User
	 @GetMapping("/getUserById/{id}")
	 Optional<User> findOneUser(@PathVariable Long id) {
	    return userRepository.findById(id);
	 }
	 
	 //Update user(put)
	 @PutMapping("/employees/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
	  @RequestBody User userDetails) {
	  User user = userRepository.findById(id);
	  
	  user.setFirstName(userDetails.getFirstName());
	  user.setEmail(userDetails.getEmail());
	  user.setLastName(userDetails.getLastName());
	  user.setUsername(userDetails.getUsername());
	  user.setPassword(userDetails.getPassword());
	  
	  final User updatedUser = userRepository.save(user);
	  return ResponseEntity.ok(updatedUser);
	 }
	 
	 //Delete User
	 @DeleteMapping("/deleteUserById/{id}")
	  void deleteUser(@PathVariable Long id) {
	    userRepository.deleteById(id);
	  }
}
