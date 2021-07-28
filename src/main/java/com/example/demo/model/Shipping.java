package com.example.demo.model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.demo.dto.ShippingDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date start;

	@Column(name = "End")
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date end;

	@ManyToOne
	@JoinColumn(name = "User", referencedColumnName = "Id")
	@NotNull
	@JsonIgnore
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "Product", referencedColumnName = "Id")
	@NotNull
	@JsonIgnore
	private Product product;

	//Proba sa ovim formaterom, kao i sa Springovim DateTimeFormat anotacijom gore
	//DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	
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
