package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ShippingDTO;
import com.example.demo.dto.ShippingRequestDTO;
import com.example.demo.model.Shipping;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShippingRepository;
import com.example.demo.utils.Const;

@Service
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	private ShippingRepository shippingRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public ShippingDTO getShipment(Long id) {
		Shipping shipment = shippingRepository.findById(id).get();

		if (shipment != null) {
			return new ShippingDTO(shipment, getState(shipment));
		}
		return null;
	}

	@Override
	public List<ShippingDTO> findAll() {
		List<ShippingDTO> result = new ArrayList<>();
		List<Shipping> shipments = shippingRepository.findAll();

		for (Shipping shipment : shipments) {
			result.add(new ShippingDTO(shipment, getState(shipment)));
		}
		return result;
	}

	@Override
	public Boolean save(ShippingRequestDTO shippingRequestDTO) {
		try {
			LocalDateTime startDate = getShippingStartDate();
			LocalDateTime endDate = getShippingEndDate(startDate);
			Shipping shipment = new Shipping(shippingRequestDTO.getUserId(), shippingRequestDTO.getProductId(),
					startDate, endDate);
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

	private LocalDateTime getShippingStartDate() {
		return LocalDateTime.now().plusDays(1);
	}

	private LocalDateTime getShippingEndDate(LocalDateTime startDate) {
		return startDate.plusDays(2);
	}

	private String getState(Shipping shipping) {
		if (LocalDateTime.now().isBefore(shipping.getStart())) {
			return Const.PREPARING_DELIVERY;
		} else if (LocalDateTime.now().isBefore(shipping.getEnd())) {
			return Const.DELIVERY_IN_PROGRESS;
		} else {
			return Const.DELIVERED;
		}
	}
}
