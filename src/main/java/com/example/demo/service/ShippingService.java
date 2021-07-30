package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ShippingDTO;

public interface ShippingService {

	ShippingDTO getShipment(Long id);

	List<ShippingDTO> findAll();

	Boolean save(ShippingDTO shippingDTO);
	
	Boolean update(ShippingDTO shippingDTO);

	Boolean delete(Long id);

	String getShippingDate();
}
