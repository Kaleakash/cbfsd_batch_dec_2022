package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Category;
import com.service.CategoryService;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping(value = "storeCategory",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeCategory(@RequestBody Category category) {
		return categoryService.storeCategory(category);
	}
	
	@GetMapping(value = "findAllCategory",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> findAllCategories() {
		return categoryService.getAllCategory();
	}
	
	@GetMapping(value = "findAllCategoryByName/{cid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Category findAllById(@PathVariable("cid") int cid) {
		return categoryService.findCategory(cid);
	}
}

