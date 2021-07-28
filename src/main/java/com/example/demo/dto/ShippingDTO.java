package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.Product;
import com.example.demo.model.Shipping;
import com.example.demo.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShippingDTO {

	private Long id;
	private Date start;
	private Date end;
	private User user;
	private Product product;

	public ShippingDTO(Shipping shipping) {
		this.id = shipping.getId();
		this.start = shipping.getStart();
		this.end = shipping.getEnd();
		this.user = shipping.getUser();
		this.product = shipping.getProduct();

	}
}
