package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.User;
import cbfsd.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public String signUp(User user) {
		userRepository.save(user);
		
		
		return "Account created successfully";
	}
	
	
	public String signIn(User user) {
		if(userRepository.signIn(user.getEmail(), user.getPassword()).size()>0) {
			return "success";
		}else {
			return "failure";
		}
	}
}
