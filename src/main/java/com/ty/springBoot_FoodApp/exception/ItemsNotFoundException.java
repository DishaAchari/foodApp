package com.ty.springBoot_FoodApp.exception;

public class ItemsNotFoundException extends RuntimeException{
	private String message="Items not found";

	@Override
	public String getMessage() {
			return message;
	}

	public ItemsNotFoundException(String message) {
		
		this.message = message;
	}
	
	
	
}
