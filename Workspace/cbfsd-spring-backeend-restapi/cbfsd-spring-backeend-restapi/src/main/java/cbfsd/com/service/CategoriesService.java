package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.CategoriesRepository;

@Service
public class CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
}
