package cbfsd.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cbfsd.com.entity.User;
import cbfsd.com.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	// http://localhost:9090/user/storeData
	
	@PostMapping(value = "storeData",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeUserDetails(@RequestBody User user) {	
		System.out.println(user);
		return userService.storeUserDetails(user);
	}
	
	// http://localhost:9090/user/allUsers
	
	@GetMapping(value = "allUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUser() {
		return userService.findAllUsers();
	}
	
	@PostMapping(value="signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public User signIn(@RequestBody User user) {
		return userService.signIng(user);
	}
}
