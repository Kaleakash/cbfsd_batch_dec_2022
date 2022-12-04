package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	ProductsRepository productRepository;
}
