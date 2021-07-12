package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Description")
	private String description;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
//	public User getUser() {
//		return this.user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//		if(user!=null && !user.getProducts().contains(this)){
//			user.getProducts().add(this);
//		}
//	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description="
				+ description + "]";
	}
}
