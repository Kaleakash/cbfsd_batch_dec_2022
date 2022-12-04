package cbfsd.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cbfsd.com.service.AdminsService;

// http://localhost:9090/admins 

@RestController
@RequestMapping("admins")
public class AdminsController {

	@Autowired
	AdminsService adminService;
	
}
