package com.ty.springBoot_FoodApp.exception;

public class ItemsIdNotFoundException extends RuntimeException {
	private String message="Item Id not found";

	@Override
	public String getMessage() {
				return message;
	}

	public ItemsIdNotFoundException(String message) {
				this.message = message;
	}
	
	
	
	
}
