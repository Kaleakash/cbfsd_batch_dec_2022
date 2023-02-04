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

import cbfsd.com.entity.Category;
import cbfsd.com.service.CategoriesService;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController {

	@Autowired
	CategoriesService categoriesService;
	
	@PostMapping(value = "storeCategory",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeCatoriesDetails(@RequestBody Category category) {
		System.out.println(category);
		return categoriesService.storeCategoriesDetails(category);
	}
	// http://localhost:9090/categories/findAllCategories
	@GetMapping(value = "findAllCategories",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> findAllCategories() {
		return categoriesService.findCategoriesDetails();
	}
	@DeleteMapping(value = "deleteCategory/{cid}")
	public String deleteProductDetails(@PathVariable("cid") int cid) {
		return categoriesService.deleteCategory(cid);
	}
}
