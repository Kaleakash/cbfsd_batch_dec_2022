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
	
	public String storeCategories(Category category) {
		category.setAddedOn(Date.valueOf(LocalDate.now()));
		categoriesRepository.save(category);
		return "Category details successfully";
	}
	
	public List<Category> findAllCategories() {
		return categoriesRepository.findAll();
	}
	
	public String deleteCategories(int cid) {
		Optional<Category> result = categoriesRepository.findById(cid);
		if(result.isPresent()) {
			Category cc = result.get();
			categoriesRepository.delete(cc);
			return "Record deleted successfully";
		}else {
			return "Record not present";
		}
	}
}
