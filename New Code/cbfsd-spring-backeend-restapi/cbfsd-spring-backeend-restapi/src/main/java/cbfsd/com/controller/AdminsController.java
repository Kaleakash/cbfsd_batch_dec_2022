package cbfsd.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cbfsd.com.entity.Admin;
import cbfsd.com.service.AdminsService;


// http://localhost:9090/admins 

@RestController
@RequestMapping("admins")
@CrossOrigin
public class AdminsController {

	@Autowired
	AdminsService adminsService;

	
	@PostMapping(value="signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Admin admin) {
		System.out.println(admin);
		return adminsService.signUp(admin);
	}
	
	// http://localhost:9090/admins/signIn
	@PostMapping(value="signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Admin admin) {
		return adminsService.signIn(admin);
	}
	
	@PostMapping(value="findAllAdmin",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Admin> findAdminDetails() {
		return adminsService.findAllAdmin();
	}
	
	@PutMapping(value="updateAdmin",produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateAdminDetails(@RequestBody Admin admin) {
		return adminsService.updateAdminInfo(admin);
	}
	
	@DeleteMapping(value = "deleteAdminInfo/:email")
	public String deleteAdminInfo(@PathVariable("email") String email) {
		return adminsService.deleteAdminInfo(email);
	}
	
	
}
