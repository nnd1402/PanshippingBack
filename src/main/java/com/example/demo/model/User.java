package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserRegistrationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Firstname")
	@NotNull
	private String firstName;

	@Column(name = "Lastname")
	@NotNull
	private String lastName;

	@Column(name = "Address")
	@NotNull
	private String address;

	@Column(name = "Country")
	@NotNull
	private String country;

	@Column(name = "Phone")
	@NotNull
	private String phone;

	@Column(name = "Email", unique = true)
	@Email
	@NotBlank
	private String email;

	@Column(name = "Username", unique = true)
	@NotNull
	private String username;

	@Column(name = "Password")
	@NotNull
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Shipping> shipments = new ArrayList<>();

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
