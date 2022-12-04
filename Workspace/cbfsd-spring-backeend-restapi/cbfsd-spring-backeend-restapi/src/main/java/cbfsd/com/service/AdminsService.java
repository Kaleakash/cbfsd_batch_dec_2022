package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.AdminsRepository;

@Service
public class AdminsService {

	@Autowired
	AdminsRepository adminRepository;
	
	
}
