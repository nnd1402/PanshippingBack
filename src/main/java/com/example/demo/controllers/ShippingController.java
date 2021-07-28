package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ShippingDTO;
import com.example.demo.service.ShippingService;
import com.example.demo.utils.Const;

@RestController
@RequestMapping(path = "/shipping")
public class ShippingController {

	@Autowired
	private ShippingService shippingService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getShipments() {
		List<ShippingDTO> shipments = shippingService.findAll();

		if (shipments.isEmpty()) {
			return new ResponseEntity<>(Const.NO_SHIPMENTS, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(shipments, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getShipment(@PathVariable Long id) {
		ShippingDTO shipment = shippingService.getShipment(id);

		if (shipment == null) {
			return new ResponseEntity<>(Const.NO_SHIPMENT, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(shipment, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Boolean isDeleted = shippingService.delete(id);

		if (!isDeleted) {
			return new ResponseEntity<>(Const.NO_SHIPMENT, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(Const.DELETED_SHIPMENT, HttpStatus.OK);
	}

	@RequestMapping(value = "/addShipment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@RequestBody ShippingDTO newShipment) {

		Date currentDate = new Date();
		if (newShipment.getEnd().before(newShipment.getStart()) 
				|| newShipment.getStart().after(newShipment.getEnd()) 
				|| newShipment.getEnd().before(currentDate)
				|| newShipment.getStart().before(currentDate)) {
			return new ResponseEntity<>(Const.FAILED_DATE_SHIPMENT, HttpStatus.BAD_REQUEST);
		}

		Boolean isSaved = shippingService.save(newShipment);
		if (isSaved) {
			return new ResponseEntity<>(Const.CREATED_SHIPMENT, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Const.FAILED_CREATION_SHIPMENT, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> edit(@RequestBody ShippingDTO newShipment, @PathVariable Long id) {

		if (shippingService.getShipment(id) == null) {
			return new ResponseEntity<>(Const.NO_SHIPMENT, HttpStatus.BAD_REQUEST);
		}

		if (newShipment.getEnd().before(newShipment.getStart())) {
			return new ResponseEntity<>(Const.FAILED_DATE_SHIPMENT, HttpStatus.BAD_REQUEST);
		}

		Boolean isUpdated = shippingService.update(newShipment);
		if (isUpdated) {
			return new ResponseEntity<>(Const.SUCCESS_UPDATE_SHIPMENT, HttpStatus.OK);
		}
		return new ResponseEntity<>(Const.FAILED_UPDATE_SHIPMENT, HttpStatus.BAD_REQUEST);
	}
}
