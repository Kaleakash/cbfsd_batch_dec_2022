package cbfsd.com.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.User;
import cbfsd.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public String storeUserDetails(User user) {
		user.setAddedOn(Date.valueOf(LocalDate.now()));
		userRepository.save(user);
		return "User Details stored successfully";
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User signIng(User user) {
		return userRepository.findUser(user.getEmail(), user.getPassword()); 
	}
}
