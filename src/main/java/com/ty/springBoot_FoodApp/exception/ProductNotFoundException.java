package com.ty.springBoot_FoodApp.exception;

public class ProductNotFoundException extends RuntimeException{

	private String message="Product not found";
	@Override
	public String getMessage() {

		return message;
	}
	public ProductNotFoundException(String message) {
				this.message = message;
	}
	
	
	
}
