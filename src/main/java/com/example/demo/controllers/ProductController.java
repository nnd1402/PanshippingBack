package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import com.example.demo.utils.Const;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> getProducts() {
		List<ProductDTO> products = productService.getAllProducts();

		if (products == null || products.isEmpty()) {
			return new ResponseEntity<>(Const.NO_PRODUCTS, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<?> getProduct(@PathVariable Long id) {
		ProductDTO product = productService.getProduct(id);

		if (product == null) {
			return new ResponseEntity<>(Const.NO_PRODUCT, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) {
		if (productService.getProduct(id) == null) {
			return new ResponseEntity<>(Const.NO_PRODUCT, HttpStatus.BAD_REQUEST);
		}

		productService.delete(id);

		return new ResponseEntity<>(Const.DELETED_PRODUCT, HttpStatus.OK);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> add(@RequestBody ProductDTO newProduct) {

		Boolean success = productService.save(newProduct);

		if (success) {
			return new ResponseEntity<>(Const.CREATED_PRODUCT, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Const.FAILED_CREATION_PRODUCT, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<?> edit(@RequestBody ProductDTO product, @PathVariable Long id) {

		if (!id.equals(product.getId())) {
			return new ResponseEntity<>(Const.NO_SEARCHED_PRODUCT, HttpStatus.BAD_REQUEST);
		}
		if (productService.getProduct(id) == null) {
			return new ResponseEntity<>(Const.NO_PRODUCT, HttpStatus.BAD_REQUEST);
		}

		productService.save(product);

		return new ResponseEntity<>(Const.SUCCESS_UPDATE_PRODUCT, HttpStatus.OK);
	}
}
