package com.ty.springBoot_FoodApp.exception;

public class UserIdNotFoundException extends RuntimeException {

	private String message = "Id Not found";

	@Override
	public String getMessage() {
		return message;
	}

	// Generate constructor
	public UserIdNotFoundException(String message) {
		this.message = message;
	}

}
