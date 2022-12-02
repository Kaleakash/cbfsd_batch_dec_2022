package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	public String storeProduct(Product product) {
	Optional<Product> result = productRepository.findById(product.getPid());
	if(result.isPresent()) {
		return "Product alreay present or pid must be unqiue";
	}else {
		productRepository.save(product);
		return "Product details stored successfully";
	}
	
	}
	
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}
	
	
}
