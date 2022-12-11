package cbfsd.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cbfsd.com.entity.Product;

import cbfsd.com.service.ProductsService;

@RestController
@RequestMapping("products")
@CrossOrigin	//cors ..
public class ProductsController {

	@Autowired
	ProductsService productService;
	
	// http://localhost:9090/products/storeProduct 
	// pass data in json format. 
	
	@PostMapping(value = "storeProduct",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.storeProduct(product);
	}
	
	// http://localhost:9090/products/findAllProducts
	@GetMapping(value = "findAllProducts",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProduct() {
		return productService.findAllProduct();
	}
	// http://localhost:9090/products/findProductById/1
	// http://localhost:9090/products/findProductById/100
	
	@GetMapping(value = "findProductById/{pid}")
	public String findProductById(@PathVariable("pid") int pid) {
		return productService.findProductById(pid);
	}
	
	// http://localhost:9090/products/findProductByPrice/35000
	
	@GetMapping(value = "findProductByPrice/{price}")
	public List<Product> findProductByPrice(@PathVariable("price") int price) {
		return productService.findProductByPrice(price);
	}
	
	// http://localhost:9090/products/updateProduct
	@PutMapping(value = "updateProduct",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody Product product) {
		return productService.updateProductDetails(product);
	}
	
	// http://localhost:9090/products/deleteProductById/1
	
	@DeleteMapping(value = "deleteProductById/{pid}")
	public String deletetProductById(@PathVariable("pid") int pid) {
		return productService.deleteProductUsingId(pid);
	}
	// http://localhost:9090/products/deleteAll
	@DeleteMapping(value = "deleteAll")
	public String deletetAll() {
		return productService.deleteAllProduct();
	}
	
	
}

