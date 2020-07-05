package com.orderservice.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.entity.OrderService;
import com.orderservice.repositry.OrderServiceRepositry;

@RestController
public class OrderServiceController {
	
	@Autowired 
	private OrderServiceRepositry orderServiceRepositry;
	@Autowired 
	private OrderServiceExProxy orderServiceExProxy;
	
	
	@GetMapping("/retrieveorderinfo")
	public List<OrderService> retrieveOrderService(){
		return orderServiceRepositry.findAll();
		
	} 
	
	@PostMapping("/neworder")
	public void createNewOrder(@Validated @RequestBody OrderService orderService) {
		orderServiceRepositry.save(orderService);
		
	}
	
	@GetMapping("retrieveOrderItemInfo/{productcode}")
	public OrderService retrieveOrderItemInfo(@PathVariable int productcode) {
		OrderService orderService=orderServiceExProxy.retrieveOrderItemInfo(productcode);
		return orderService;

	}

	
}
