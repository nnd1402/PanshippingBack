package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue
	private @Getter @Setter Long id;

	@Column(name = "Name", nullable = false)
	private @Getter @Setter String name;

	@Column(name = "Price", nullable = false)
	private @Getter @Setter double price;
	
	@Lob
	@Column (name = "Image")
	private @Getter @Setter byte[] image;

	@Column(name = "Quantity", nullable = false)
	private @Getter @Setter int quantity;

	@Column(name = "Description")
	private @Getter @Setter String description;

	@ManyToOne
	@JoinColumn(name = "User", referencedColumnName = "Id", nullable = false)
	private @Getter @Setter User user;

	public Product(ProductDTO productDTO) {
		this.id = productDTO.getId();
		this.name = productDTO.getName();
		this.price = productDTO.getPrice();
		this.image = productDTO.getImage();
		this.quantity = productDTO.getQuantity();
		this.description = productDTO.getDescription();
		this.user = productDTO.getUser();
	}
}
