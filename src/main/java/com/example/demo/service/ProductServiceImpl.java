package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO getProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			return new ProductDTO(product.get());
		}
		return null;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> result = new ArrayList<>();
		List<Product> products = productRepository.findAll();

		for (Product product : products) {
			result.add(new ProductDTO(product));
		}
		return result;
	}

	@Override
	public Boolean save(ProductDTO productDTO) {
		Product product = new Product(productDTO);
		try {
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean saveImageFile(Long Id, MultipartFile file) {
		try {
			Product product = productRepository.findById(Id).get();

			try {
				product.setImage(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}

			productRepository.save(product);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
