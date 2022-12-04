package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository orderRepository;
	
}
