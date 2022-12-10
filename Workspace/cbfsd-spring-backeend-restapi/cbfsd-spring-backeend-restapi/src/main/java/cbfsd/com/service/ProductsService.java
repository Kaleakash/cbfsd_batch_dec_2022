package cbfsd.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.Product;

import cbfsd.com.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	ProductsRepository productRepository;
	
	
	public String storeProduct(Product product) {
		productRepository.save(product);			// insert query 
		return "Product Details stored successfully";
	}
	
	public List<Product> findAllProduct() {
		return productRepository.findAll();			// select query 
	}
	
	public String findProductById(int productid) {
		Optional<Product> result = productRepository.findById(productid);// USING pk
		if(result.isPresent()) {
			Product pp	 = result.get();
			return pp.toString();
		}else {
			return "Product not present";
		}
	}
	
	public String updateProductDetails(Product product) {
		Optional<Product> result = productRepository.findById(product.getProductId());// USING pk
		if(result.isPresent()) {
			Product pp	 = result.get();
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
		Optional<Product> result = productRepository.findById(productid);// USING pk
		if(result.isPresent()) {
			Product pp	 = result.get();
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
	
	public List<Product> findProductByPrice(int price){
		return productRepository.searchProductByPrice(price);
	}
	
}
