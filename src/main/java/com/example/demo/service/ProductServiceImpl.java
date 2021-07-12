package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(Long id) {
		Optional<Product> product =  productRepository.findById(id);
		
		if (product.isPresent()) {
			return  new Product();
		} 
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Boolean delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product != null){
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
