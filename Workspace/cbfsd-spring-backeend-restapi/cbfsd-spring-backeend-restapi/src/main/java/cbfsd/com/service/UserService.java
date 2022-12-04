package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
