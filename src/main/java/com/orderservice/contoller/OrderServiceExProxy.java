package com.orderservice.contoller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderservice.entity.OrderService;

@FeignClient(name="orderItemService", url="localhost:8001")
public interface OrderServiceExProxy {
    @GetMapping("retrieveOrderItemInfo/{productcode}")
	public OrderService retrieveOrderItemInfo(@PathVariable Integer productcode); 
}
