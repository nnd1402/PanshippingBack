package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ShippingDTO;
import com.example.demo.dto.ShippingRequestDTO;
import com.example.demo.model.Product;
import com.example.demo.model.Shipping;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShippingRepository;
import com.example.demo.utils.Const;

@Service
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	private ShippingRepository shippingRepository;
	
	@Autowired
	private ProductRepository productRepository;

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
	public Boolean save(ShippingRequestDTO shippingRequestDTO) {
		try {
			LocalDateTime startDate = getShippingStartDate();
			LocalDateTime endDate = getShippingEndDate(startDate);
			Shipping shipment = new Shipping(shippingRequestDTO.getUserId(), shippingRequestDTO.getProductId(),
					startDate, endDate);
			Product product = productRepository.getById(shippingRequestDTO.getProductId());
			product.setIsOrdered(true);
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
		return LocalDateTime.now().plusDays(Const.PENDING_DAYS);
	}

	private LocalDateTime getShippingEndDate(LocalDateTime startDate) {
		return startDate.plusDays(Const.SHIPPING_DAYS);
	}
}
