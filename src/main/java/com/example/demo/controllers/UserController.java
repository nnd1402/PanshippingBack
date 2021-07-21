package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.Const;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> getUsers() {
		List<UserRegistrationDTO> users = userService.findAll();

		if (users.isEmpty()) {
			return new ResponseEntity<>(Const.NO_USERS, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<?> getUser(@PathVariable Long id) {
		UserRegistrationDTO user = userService.getUser(id);

		if (user == null) {
			return new ResponseEntity<>(Const.NO_USER, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) {
		Boolean success = userService.delete(id);

		if (!success) {
			return new ResponseEntity<>(Const.NO_USER, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(Const.DELETED_USER, HttpStatus.OK);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@RequestBody UserRegistrationDTO newUser) {
		User databaseUser = userRepository.findByUsername(newUser.getUsername());
		if (databaseUser != null) {
			return new ResponseEntity<>(Const.FAILED_USERNAME_EXISTS, HttpStatus.BAD_REQUEST);
		}

		Boolean success = userService.save(newUser);

		if (success) {
			return new ResponseEntity<>(Const.CREATED_USER, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Const.FAILED_CREATION_USER, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> edit(@RequestBody UserRegistrationDTO userDTO, @PathVariable Long id) {

		if (userService.getUser(id) == null) {
			return new ResponseEntity<>(Const.NO_USER, HttpStatus.BAD_REQUEST);
		}

		User databaseUser = userRepository.findByUsername(userDTO.getUsername());

		if (databaseUser != null && !databaseUser.getId().equals(userDTO.getId())) {
			return new ResponseEntity<>(Const.FAILED_USERNAME_EXISTS, HttpStatus.BAD_REQUEST);
		}

		Boolean success = userService.update(userDTO);
		if (success) {
			return new ResponseEntity<>(Const.SUCCESS_UPDATE_USER, HttpStatus.OK);
		}
		return new ResponseEntity<>(Const.FAILED_UPDATE_USER, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> post(@RequestBody UserLoginDTO user) {
		UserRegistrationDTO loginUser = userService.loginUsername(user);

		if (loginUser != null) {
			return new ResponseEntity<>(loginUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Const.LOGIN_FAIL, HttpStatus.BAD_REQUEST);
		}
	}
}
