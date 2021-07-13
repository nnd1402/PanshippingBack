package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {

	Product getProduct(Long id);
	List<Product> getAllProducts();
	Product save(Product product);
	Boolean delete(Long id);
}
