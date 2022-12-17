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
	ProductsRepository productsRepository;
	
	
	public String storeProduct(Product product) {
		productsRepository.save(product);			// insert query 
		return "Product Details stored successfully";
	}
	
	public List<Product> findAllProduct() {
		return productsRepository.findAll();			// select query 
	}
	
	public String findProductById(int productid) {
		Optional<Product> result = productsRepository.findById(productid);// USING pk
		if(result.isPresent()) {
			Product pp	 = result.get();
			return pp.toString();
		}else {
			return "Product not present";
		}
	}
	
	public String updateProductDetails(Product product) {
		Optional<Product> result = productsRepository.findById(product.getProductId());// USING pk
		if(result.isPresent()) {
			Product pp	 = result.get();
			pp.setPrice(product.getPrice());
			/*
			 * 	we can update more property 
			 * 
			 */
			productsRepository.saveAndFlush(pp);
			return "Product Details updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteProductUsingId(int productid) {
		Optional<Product> result = productsRepository.findById(productid);// USING pk
		if(result.isPresent()) {
			Product pp	 = result.get();
			productsRepository.deleteById(pp.getProductId());
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteAllProduct() {
		productsRepository.deleteAll();
		return "Add product deleted";
	}
	
	public List<Product> findProductByPrice(int price){
		return productsRepository.searchProductByPrice(price);
	}
	
}
