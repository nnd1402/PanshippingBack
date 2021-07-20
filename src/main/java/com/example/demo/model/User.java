package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserRegistrationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue
	private @Getter @Setter Long id;

	@Column(name = "Firstname", nullable = false)
	private @Getter @Setter String firstName;

	@Column(name = "Lastname", nullable = false)
	private @Getter @Setter String lastName;

	@Column(name = "Address", nullable = false)
	private @Getter @Setter String address;

	@Column(name = "Country", nullable = false)
	private @Getter @Setter String country;

	@Column(name = "Phone", nullable = false)
	private @Getter @Setter String phone;

	@Column(name = "Email", nullable = false)
	private @Getter @Setter String email;

	@Column(name = "Username", nullable = false)
	private @Getter @Setter String username;

	@Column(name = "Password", nullable = false)
	private @Getter @Setter String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private @Getter @Setter List<Product> products = new ArrayList<>();

	public User(Long id) {
		this.id = id;
	}

	public User(UserRegistrationDTO userDTO) {
		this.id = userDTO.getId();
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.email = userDTO.getEmail();
		this.address = userDTO.getAddress();
		this.country = userDTO.getCountry();
		this.phone = userDTO.getPhone();
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
	}

	public User(UserLoginDTO userLoginDTO) {
		this.username = userLoginDTO.getUsername();
		this.password = userLoginDTO.getPassword();
	}
}
