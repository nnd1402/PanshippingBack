package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private @Getter @Setter Long id;
	private @Getter @Setter String name;
	private @Getter @Setter double price;
	private @Getter @Setter byte[] image;
	private @Getter @Setter int quantity;
	private @Getter @Setter String description;
	private @Getter @Setter User user;

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.image = product.getImage();
		this.quantity = product.getQuantity();
		this.description = product.getDescription();
		this.user = product.getUser();
	}
}
