package com.ty.springBoot_FoodApp.exception;

public class FoodOrderIdNotFoundException extends RuntimeException {
	private String message = "FoodOrder ID not found";

	@Override
	public String getMessage() {

		return message;
	}

	public FoodOrderIdNotFoundException(String message) {

		this.message = message;
	}

}
