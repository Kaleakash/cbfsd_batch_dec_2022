package cbfsd.com.service;

import java.sql.Date;
import java.time.LocalDate;
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
	
	public String addProduct(Product product) {
		product.setAddedOn(Date.valueOf(LocalDate.now()));
		productRepository.save(product);
		return "Product Details stored successfully";
	}
	
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}
	
	public String deleteProductDetails(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			productRepository.delete(p);
			return "Product deails deleted successfully";
		}else {
			return "Product details not present";
		}
	}
	
	public List<Product> findAllProductWithImage() {
		return productRepository.findProductWithImages();
	}
}
