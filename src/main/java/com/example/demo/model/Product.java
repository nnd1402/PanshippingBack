package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.dto.ProductDTO;

@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Price", nullable = false)
	private double price;

	@Column(name = "Quantity", nullable = false)
	private int quantity;

	@Column(name = "Description", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "User", referencedColumnName = "Id")
	private User user;

	public Product() {
	}

	public Product(ProductDTO productDTO) {
		this.id = productDTO.getId();
		this.name = productDTO.getName();
		this.price = productDTO.getPrice();
		this.quantity = productDTO.getQuantity();
		this.description = productDTO.getDescription();
		this.user = productDTO.getUser();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
