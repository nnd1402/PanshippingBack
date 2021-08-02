package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.model.Shipping;
import com.example.demo.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	private Long id;
	private String name;
	private double price;
	private byte[] image;
	private int quantity;
	private String description;
	private Boolean isOrdered;
	private User user;
	private List<Shipping> shipping;

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.image = product.getImage();
		this.quantity = product.getQuantity();
		this.description = product.getDescription();
		this.isOrdered = product.getIsOrdered();
		this.user = product.getUser();
		this.shipping = product.getShipping();
	}
}
