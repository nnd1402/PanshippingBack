package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//	@Modifying
//	@Transactional
//	@Query("update Product p set p.image = null where p.id = :id")
//	void deleteImageById(@Param(value = "id") Long id);
}
