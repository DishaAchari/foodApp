package com.ty.springBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodOrderController {
	
	@Autowired
	private FoodOrderService service;
	
	@ApiOperation(value = "Save FoodOrder", notes = "API is used to save FoodOrder based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given foodOrder id")})

	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> savefoodOrder(@Valid@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@ApiOperation(value = "Update FoodOrder", notes = "API is used to update FoodOrder based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given foodOrder id")})
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updaFoodOrder(@Valid@RequestBody FoodOrder foodOrder,@RequestParam int id) {
		return service.updateFoodOrder(foodOrder, id);
	}
	
	@ApiOperation(value = "Delete FoodOrder", notes = "API is used to delete FoodOrder based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given foodOrder id")})
	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@Valid@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}
	
	@ApiOperation(value = "Get FoodOrder", notes = "API is used to get FoodOrder based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Successfully saved"),@ApiResponse(code = 404,message = "ID not found for the given foodOrder id")})
	
	@GetMapping("/getFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@Valid@RequestParam int id) {
		return service.getFoodOrderById(id);
	}
}
