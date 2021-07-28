package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.dto.ShippingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_shipping")
@Data
@NoArgsConstructor
public class Shipping {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "Start")
	@NotNull
	private Date start;
	
	@Column(name = "End")
	@NotNull
	private Date end;
	
	@ManyToOne
	@JoinColumn(name = "User", referencedColumnName = "Id", nullable = false)
	@JsonIgnore
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "Product", referencedColumnName = "Id", nullable = false)
	@JsonIgnore
	private Product product;
	
	public Shipping(Long id) {
		this.id = id;
	}
	
	public Shipping(ShippingDTO shippingDTO) {
		this.id = shippingDTO.getId();
		this.start = shippingDTO.getStart();
		this.end = shippingDTO.getEnd();
		this.user = shippingDTO.getUser();
		this.product = shippingDTO.getProduct();
	}
	
}
