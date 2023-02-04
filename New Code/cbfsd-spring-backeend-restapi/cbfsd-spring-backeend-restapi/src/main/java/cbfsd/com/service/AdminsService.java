package cbfsd.com.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.Admin;
import cbfsd.com.repository.AdminsRepository;


@Service
public class AdminsService {

	@Autowired
	AdminsRepository adminsRepository;
	

	public String signUp(Admin admin) {
		admin.setAddedOn(Date.valueOf(LocalDate.now()));
		admin.setLoginType(1);
		adminsRepository.save(admin);
		return "Admin record stored successfully";
	}
	
	public String signIn(Admin admin) {
		if(adminsRepository.signIn(admin.getEmail(), admin.getPassword())!=null) {
			return "Successfully login";
		}else {
			return "InValid email id or password";
		}
	}
	
	public List<Admin> findAllAdmin() {
		return adminsRepository.findAll();
	}
	
	public String deleteAdminInfo(String email) {
		if(adminsRepository.deleteAdminInfo(email)>0) {
			return "Record deleted successfully";
		}else {
			return "Record not present";
		}
	}
	
	public String updateAdminInfo(Admin admin) {
		Optional<Admin> result = adminsRepository.findById(admin.getAdminId());
		if(result.isPresent()) {
			Admin ad = result.get();
			ad.setEmail(admin.getEmail());
			ad.setPassword(admin.getPassword());
			ad.setFullName(admin.getFullName());
			adminsRepository.saveAndFlush(ad);
			return "Admin recod updated successsfully";
		}else {
			return "Record didn't update";
		}
		
	}
}
