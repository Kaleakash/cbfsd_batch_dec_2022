package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	// http://localhost:8080/storeProduct data :{"pid":1,"pname":"TV","price":55000}

	@PostMapping(value="storeProduct",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.storeProduct(product);
	}
	
	// http://localhost:8080/findAllProduct 
	
	@GetMapping(value = "findAllProduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct() {
		return productService.findAllProduct();
	}
	
}
