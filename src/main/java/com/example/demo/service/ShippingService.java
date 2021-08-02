package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ShippingDTO;
import com.example.demo.dto.ShippingRequestDTO;

public interface ShippingService {

	ShippingDTO getShipment(Long id);

	List<ShippingDTO> findAll();

	Boolean save(ShippingRequestDTO shippingDTO);
	
	Boolean update(ShippingDTO shippingDTO);

	Boolean delete(Long id);
}
