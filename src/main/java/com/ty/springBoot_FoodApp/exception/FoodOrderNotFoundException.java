package com.ty.springBoot_FoodApp.exception;

public class FoodOrderNotFoundException extends RuntimeException {
	private String message = "FoodOrder not found";

	@Override
	public String getMessage() {
		return message;
	}

	public FoodOrderNotFoundException(String message) {

		this.message = message;
	}

}
