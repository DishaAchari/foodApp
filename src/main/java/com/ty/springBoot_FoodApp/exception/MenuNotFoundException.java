package com.ty.springBoot_FoodApp.exception;

public class MenuNotFoundException extends RuntimeException {

	private String message = "Menu not found";

	@Override
	public String getMessage() {

		return message;

	}

	public MenuNotFoundException(String message) {

		this.message = message;
	}

}
