package com.example.demo.dto;

import com.example.demo.model.User;

public class UserLoginDTO {

	private String username;
	private String password;

	public UserLoginDTO() {
	}

	public UserLoginDTO(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
