package com.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class OrderService {
	
	@Id
	@GeneratedValue
	private int Productcode;
	@Size(min=2, message = "Productname should be atleast two charactor")
	private String Productname;
	@Size(min=2, message = "Quantity should be atleast two charactor")
	private String Quantity;
	
	public OrderService() {
		super();
	}
	
	public int getProductcode() {
		return Productcode;
	}
	public void setProductcode(int productcode) {
		Productcode = productcode;
	}
	public String getProductname() {
		return Productname;
	}
	
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
}
