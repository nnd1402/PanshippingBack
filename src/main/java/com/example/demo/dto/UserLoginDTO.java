package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

	private @Getter @Setter String username;
	private @Getter @Setter String password;

	public UserLoginDTO(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
}
