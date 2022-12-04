package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.WishlistRepository;

@Service
public class WishlistService {

	@Autowired
	WishlistRepository wishlistRepository;
}
