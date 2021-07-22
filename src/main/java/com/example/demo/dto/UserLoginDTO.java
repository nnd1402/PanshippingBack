package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

	private String username;
	private String password;

	public UserLoginDTO(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
}
