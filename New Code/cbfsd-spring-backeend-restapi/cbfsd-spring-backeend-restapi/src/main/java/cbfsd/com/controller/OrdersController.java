package cbfsd.com.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cbfsd.com.entity.Order;
import cbfsd.com.entity.Orderitem;
import cbfsd.com.service.OrdersService;

@RestController
@RequestMapping("orders")
@CrossOrigin
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	// http://localhost:9090/orders/placeOrder
	@PostMapping(value = "placeOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String orderPlaced(@RequestBody Order order) {
		System.out.println(order);
		System.out.println(order.getOrderitems().size());
		//return "Order placed successfully";
		//return ordersService.saveAllOrders(orderItems);
		return ordersService.saveOrderDetails(order);
	}
//	
//	@PostMapping(value = "userOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String userOrderDetails(@RequestBody Order order) {
//		
//	}
}
