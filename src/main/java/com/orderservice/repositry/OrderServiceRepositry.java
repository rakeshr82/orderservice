package com.orderservice.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.entity.OrderService;


@Repository
public interface OrderServiceRepositry extends JpaRepository<OrderService, Integer> {

}
