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

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(path="/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productService.getAllProducts();
		
		if(products == null || products.isEmpty()){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<Product> getUser(@PathVariable Long id){
		Product product = productService.getProduct(id);
		
		if (product==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<Product> delete(@PathVariable Long id){
		if(productService.getProduct(id) == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		productService.delete(id);
				
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST,
			consumes="application/json")
		public ResponseEntity<Product> add(@RequestBody Product newProduct){
		Product savedProduct = productService.save(newProduct);
		
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<Product> edit(
			@RequestBody Product product,
			@PathVariable Long id){
		
		if(!id.equals(product.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Product persisted = productService.save(product);
		
		return new ResponseEntity<>(persisted,HttpStatus.OK);
	}
}
