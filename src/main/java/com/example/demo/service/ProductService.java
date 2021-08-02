package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;

public interface ProductService {
	ProductDTO getProduct(Long id);

	List<ProductDTO> getAllProducts();
	
	List<ProductDTO> getProductsByUserId(Long userId);

	Boolean save(ProductDTO productDTO);

	Boolean delete(Long id);
	
	Boolean saveImageFile(Long Id, MultipartFile file);

	List<ProductDTO> getBoughtProducts(Long userId);

	List<ProductDTO> getAvailableToBuy(Long userId);
}
