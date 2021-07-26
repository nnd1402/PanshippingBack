package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String country;
	private String phone;
	private String username;
	private String password;

	public UserRegistrationDTO(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.country = user.getCountry();
		this.phone = user.getPhone();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
}
