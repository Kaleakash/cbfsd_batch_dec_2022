package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.Admin;
import cbfsd.com.repository.AdminsRepository;

@Service
public class AdminsService {

	@Autowired
	AdminsRepository adminRepository;
	
	public String signInAdmin(Admin admin) {
		if(adminRepository.signIn(admin.getEmail(), admin.getPassword())!=null) {
			return "success";
		}else {
			return "failure";
		}
	}
}
