package com.ty.springBoot_FoodApp.exception;

public class UserNotFoundException extends RuntimeException {
	private String message = "User not found";

	@Override
	public String getMessage() {

		return message;
	}

	public UserNotFoundException(String message) {
				this.message = message;
	}

}
