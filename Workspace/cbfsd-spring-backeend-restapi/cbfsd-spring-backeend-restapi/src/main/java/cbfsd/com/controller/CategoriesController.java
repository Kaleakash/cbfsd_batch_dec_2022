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
	// http://localhost:9090/categories/storeCategories
	
	@PostMapping(value = "storeCategories",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeCategories(@RequestBody Category category) {
		return categoriesService.storeCategories(category);
	}
	
	// http://localhost:9090/categories/findCategories
	
	@GetMapping(value = "findCategories",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> findCategories() {
		return categoriesService.findAllCategories();
	}
	
	// http://localhost:9090/categories/deleteCategories/1
	
	@DeleteMapping(value = "deleteCategories/{cid}")
	public String deleteCategories(@PathVariable("cid") int cid) {
		return categoriesService.deleteCategories(cid);
	}
	
}
