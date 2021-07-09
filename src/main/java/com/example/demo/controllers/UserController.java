package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<UserRegistrationDTO>> getUsers(){
		List<UserRegistrationDTO> users = userService.findAll();
		
		if(users == null || users.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<UserRegistrationDTO> getUser(@PathVariable Long id){
		UserRegistrationDTO user = userService.getUser(id);
		
		if (user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<User> delete(@PathVariable Long id){
		if(userService.getUser(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userService.delete(id);
				
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<UserRegistrationDTO> add(@RequestBody UserRegistrationDTO newUser){
		UserRegistrationDTO savedUser = userService.save(newUser);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<UserRegistrationDTO> edit(
			@RequestBody UserRegistrationDTO userDTO,
			@PathVariable Long id){
		
		if(!id.equals(userDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserRegistrationDTO persisted = userService.save(userDTO);
		
		return new ResponseEntity<>(persisted,HttpStatus.OK);
	}
}
