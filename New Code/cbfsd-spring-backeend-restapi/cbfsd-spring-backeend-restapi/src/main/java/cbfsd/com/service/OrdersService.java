package cbfsd.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.entity.Order;
import cbfsd.com.entity.Orderitem;
import cbfsd.com.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository orderRepository;

//	
//	public String saveAllOrders(List<Orderitem> orderItems) {
//		orderRepository.saveAll(orderItems);
//		return "All order placed successfully";
//	}
	
	public String saveOrderDetails(Order order) {
		orderRepository.save(order);
		return "Order placed successfully";
	}
}
