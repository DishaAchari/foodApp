package com.ty.springBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "Save User", notes = "API is used to save user for given user id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully Saved"),
			@ApiResponse(code = 400,message = "ID not found for  the given user ID")})
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}
	
	@ApiOperation(value = "Update User", notes = "API is used to update user for given user id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully updated"),
			@ApiResponse(code = 404,message ="ID not found for the given user ID" )})
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestParam int id,@RequestBody User user) {
		return service.updateUser(id, user);
	}
	
	@ApiOperation(value = "Delete User", notes="API is used to delete user for given user id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully deleted"),
			@ApiResponse(code = 404,message = "ID not found for the given user ID")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid @PathVariable int id) {
		return service.deleteUser(id);
	}
	
	@ApiOperation(value = "Get User By ID",notes = "API is used to get user by ID")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "User id found"),@ApiResponse(code = 404,message = "User ID not found")})
	@GetMapping("/getUserById")
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid @RequestParam int id) {
		return service.getUserById(id);
	}
}
