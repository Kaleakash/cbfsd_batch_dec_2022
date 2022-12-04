package cbfsd.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.Products;
import cbfsd.com.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	ProductsRepository productRepository;
	
	
	public String storeProduct(Products product) {
		productRepository.save(product);			// insert query 
		return "Product Details stored successfully";
	}
	
	public List<Products> findAllProduct() {
		return productRepository.findAll();			// select query 
	}
	
	public String findProductById(int productid) {
		Optional<Products> result = productRepository.findById(productid);// USING pk
		if(result.isPresent()) {
			Products pp	 = result.get();
			return pp.toString();
		}else {
			return "Product not present";
		}
	}
	
	public String updateProductDetails(Products product) {
		Optional<Products> result = productRepository.findById(product.getProductId());// USING pk
		if(result.isPresent()) {
			Products pp	 = result.get();
			pp.setPrice(product.getPrice());
			/*
			 * 	we can update more property 
			 * 
			 */
			productRepository.saveAndFlush(pp);
			return "Product Details updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteProductUsingId(int productid) {
		Optional<Products> result = productRepository.findById(productid);// USING pk
		if(result.isPresent()) {
			Products pp	 = result.get();
			productRepository.deleteById(pp.getProductId());
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteAllProduct() {
		productRepository.deleteAll();
		return "Add product deleted";
	}
	
	public List<Products> findProductByPrice(int price){
		return productRepository.searchProductByPrice(price);
	}
	
}
