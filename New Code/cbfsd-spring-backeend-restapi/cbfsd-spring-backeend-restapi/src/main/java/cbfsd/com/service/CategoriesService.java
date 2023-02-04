package cbfsd.com.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.Category;
import cbfsd.com.repository.CategoriesRepository;

@Service
public class CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	
	public String storeCategoriesDetails(Category category) {
		category.setAddedOn(Date.valueOf(LocalDate.now()));
		categoriesRepository.save(category);
		
		return "Category Details stored successfully";
	}
	
	public List<Category> findCategoriesDetails() {
		return categoriesRepository.findAll();
	}
	
	public String deleteCategory(int cid) {
		Optional<Category> result = categoriesRepository.findById(cid);
		if(result.isPresent()) {
			Category cc = result.get();
			categoriesRepository.delete(cc);
			return "Categories details deleted successfully";
		}else {
			return "Categories details not present";
		}
	}
}
