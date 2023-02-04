package cbfsd.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cbfsd.com.entity.Product;
import cbfsd.com.service.ProductsService;

@RestController
@RequestMapping("products")
@CrossOrigin //oo
public class ProductsController {

	@Autowired
	ProductsService productService;
	
	// http://localhost:9090/products/storeProduct
	
	@PostMapping(value = "storeProduct",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product product) {
		System.out.println(product);
		//return "done";
		return productService.addProduct(product);
	}
	// http://localhost:9090/products/findProduct
	@GetMapping(value = "findProduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProduct() {
		return productService.findAllProduct();
	}
	@DeleteMapping(value = "deleteProduct/{pid}")
	public String deleteProduct(@PathVariable("pid") int pid) {
		return productService.deleteProductDetails(pid);
	}
	
	// http://localhost:9090/products/findProductWithImages
		@GetMapping(value = "findProductWithImages",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Product> findAllProductWithImages() {
			return productService.findAllProductWithImage();
		}
}


