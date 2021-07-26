package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_product")
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Name")
	@NotNull
	private String name;

	@Column(name = "Price")
	@NotNull
	private double price;
	
	@Lob
	@Column (name = "Image")
	private byte[] image;

	@Column(name = "Quantity")
	@NotNull
	private int quantity;

	@Column(name = "Description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "User", referencedColumnName = "Id", nullable = false)
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "shipping", referencedColumnName = "Id")
	@JsonIgnore
	private Shipping shipping;

	public Product(ProductDTO productDTO) {
		this.id = productDTO.getId();
		this.name = productDTO.getName();
		this.price = productDTO.getPrice();
		this.image = productDTO.getImage();
		this.quantity = productDTO.getQuantity();
		this.description = productDTO.getDescription();
		this.user = productDTO.getUser();
		this.shipping = productDTO.getShipping();
	}

	public Product(ProductDTO productDTO, MultipartFile file) {
		this.id = productDTO.getId();
		this.name = productDTO.getName();
		this.price = productDTO.getPrice();
		this.image = productDTO.getImage();
		this.quantity = productDTO.getQuantity();
		this.description = productDTO.getDescription();
		this.user = productDTO.getUser();
	}
}
