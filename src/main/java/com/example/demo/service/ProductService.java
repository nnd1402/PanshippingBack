package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDTO;

public interface ProductService {
	ProductDTO getProduct(Long id);

	List<ProductDTO> getAllProducts();

	Boolean save(ProductDTO productDTO);

	Boolean delete(Long id);
}
