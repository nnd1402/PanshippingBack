package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ShippingDTO;
import com.example.demo.model.Shipping;
import com.example.demo.repository.ShippingRepository;

@Service
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	private ShippingRepository shippingRepository;

	@Override
	public ShippingDTO getShipment(Long id) {
		Optional<Shipping> shipment = shippingRepository.findById(id);

		if (shipment.isPresent()) {
			return new ShippingDTO(shipment.get());
		}
		return null;
	}

	@Override
	public List<ShippingDTO> findAll() {
		List<ShippingDTO> result = new ArrayList<>();
		List<Shipping> shipments = shippingRepository.findAll();

		for (Shipping shipment : shipments) {
			result.add(new ShippingDTO(shipment));
		}
		return result;
	}

	@Override
	public Boolean save(ShippingDTO shippingDTO) {
		try {
			Shipping shipment = new Shipping(shippingDTO);
			shippingRepository.save(shipment);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean update(ShippingDTO shippingDTO) {
		Shipping shipment = new Shipping(shippingDTO);
		try {
			shippingRepository.save(shipment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean delete(Long id) {
		Optional<Shipping> shipment = shippingRepository.findById(id);
		if (shipment.isPresent()) {
			shippingRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
