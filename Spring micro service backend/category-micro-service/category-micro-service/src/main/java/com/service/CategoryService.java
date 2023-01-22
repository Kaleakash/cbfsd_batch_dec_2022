package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	
	public String storeCategory(Category category) {
		categoryRepository.save(category);
		return "Category details stored successfully";
	}
	
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	
//	public Category findCategory(String cname) {
//		List<Category> categoryList= categoryRepository.findByName(cname);
//		return categoryList.get(0);
//	}
	
	public Category findCategory(int cid) {
	Optional<Category> result = categoryRepository.findById(cid);
	if(result.isPresent()) {
		return result.get();
	}else {
		return null;
	}
	
}
	
}
