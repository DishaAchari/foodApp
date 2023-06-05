package com.ty.springBoot_FoodApp.exception;

public class ProductIdNotFoundException extends RuntimeException {
	private String message="Product ID not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ProductIdNotFoundException(String message) {
		this.message = message;
	}
	
	
	
}
