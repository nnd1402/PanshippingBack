package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {

	private @Getter @Setter Long id;
	private @Getter @Setter String firstName;
	private @Getter @Setter String lastName;
	private @Getter @Setter String email;
	private @Getter @Setter String address;
	private @Getter @Setter String country;
	private @Getter @Setter String phone;
	private @Getter @Setter String username;
	private @Getter @Setter String password;

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
