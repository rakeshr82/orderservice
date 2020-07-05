package com.springboot.practice.restfulwebservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")

public class OrderNotFound extends RuntimeException {

	public OrderNotFound(String message) {
		super(message);
	}

}
