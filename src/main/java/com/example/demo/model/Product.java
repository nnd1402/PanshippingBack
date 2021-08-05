package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	@NotNull
	private String name;

	@Column(name = "Price")
	@NotNull
	private double price;

	@Lob
	@Column(name = "Image")
	private byte[] image;

	@Column(name = "Quantity")
	@NotNull
	private int quantity;

	@Column(name = "Description")
	private String description;

	@Column(name = "Ordered", insertable = false)
	private Boolean ordered;

	@ManyToOne
	@JoinColumn(name = "User", referencedColumnName = "Id")
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Shipping> shipping = new ArrayList<>();

	public Product(Long id) {
		this.id = id;
	}

	public Product(ProductDTO productDTO) {
		this.id = productDTO.getId();
		this.name = productDTO.getName();
		this.price = productDTO.getPrice();
		this.image = productDTO.getImage();
		this.quantity = productDTO.getQuantity();
		this.description = productDTO.getDescription();
		this.ordered = productDTO.getOrdered();
		this.user = productDTO.getUser();
		this.shipping = productDTO.getShipping();
	}
}
