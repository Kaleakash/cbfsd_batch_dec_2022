package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Category;
import com.bean.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository productRepsository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String storeProduct(Product product) {
		Optional<Product> result = productRepsository.findById(product.getPid());
		if(result.isPresent()) {
			return "Product id must be unique";
		}else {
		Category cc = restTemplate.getForObject("http://CATEGORY-MICRO-SERVICE/category/findAllCategoryByName/"+product.getCid(), Category.class);
			System.out.println(cc.getCid()+" "+cc.getCname());
			product.setCid(cc.getCid());
			productRepsository.save(product);
			return "Product Details stored successfully";
		}
	}
	
	public List<Product> getAllProducts() {
		return productRepsository.findAll();
	}
	
	public String findProduct(int pid) {
		Optional<Product> result = productRepsository.findById(pid);
		if(result.isPresent()) {
			return result.get().toString();
		}else {
			return "Product not present";
		}
	}
	
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepsository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			productRepsository.delete(p);
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String updateProduct(Product pp) {
		Optional<Product> result = productRepsository.findById(pp.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setUrl(pp.getUrl());
			p.setPrice(pp.getPrice());
			productRepsository.saveAndFlush(p);
			return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteAllProduct() {
		productRepsository.deleteAll();
		return "All Record deleted";
	}
	
}
