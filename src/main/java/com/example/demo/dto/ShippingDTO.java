package com.example.demo.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
	private List<Product> products = new ArrayList<>();
	
	public ShippingDTO(Long id) {
		this.id = id;
	}
	
	public ShippingDTO(Shipping shipping) {
		this.id = shipping.getId();
		this.start = shipping.getStart();
		this.end = shipping.getEnd();
		this.user = shipping.getUser();
		this.products = shipping.getProducts();
	}
}
