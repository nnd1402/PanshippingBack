package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.User;

public class ProductDTO {

	private Long id;
	private String name;
	private double price;
	private byte[] image;
	private int quantity;
	private String description;
	private User user;

	public ProductDTO() {
	};

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.image = product.getImage();
		this.quantity = product.getQuantity();
		this.description = product.getDescription();
		this.user = product.getUser();
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

	public void setPrice(double price) {
		this.price = price;
	}
	
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
