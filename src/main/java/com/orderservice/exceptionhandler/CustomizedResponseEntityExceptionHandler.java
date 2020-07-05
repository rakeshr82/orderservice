package com.orderservice.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(OrderNotFound.class)
	public final  ResponseEntity OrderNotFoundException(Exception ex, WebRequest request) throws OrderNotFound {
		ExceptionResponse  ex1 =   new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@Override 
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse  ex1 =   new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
		
		return new ResponseEntity(ex1, HttpStatus.BAD_REQUEST);
	}
	
}
