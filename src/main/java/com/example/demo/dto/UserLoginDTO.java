package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDTO {

	private String username;
	private String password;

	public UserLoginDTO(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
}
