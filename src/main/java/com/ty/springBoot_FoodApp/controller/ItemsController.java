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
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.service.ItemsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService service;
	
	@ApiOperation(value = "Save Items", notes = "API is used to save Items based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given Item id")})
	@PostMapping("/saveItems")
	public ResponseEntity<ResponseStructure<Items>> saveItems(@Valid@RequestBody Items items) {
		return service.saveItems(items);
	}
	
	@ApiOperation(value = "Update Items", notes = "API is used to update Items based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given Item id")})
	@PutMapping("/updateItems")
	public ResponseEntity<ResponseStructure<Items>> updateItems(@Valid@RequestBody Items items,@RequestParam int id) {
		return service.updateItems(items,id);	
	}

	@ApiOperation(value = "Delete Items", notes = "API is used to delete Items based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given Item id")})
	@DeleteMapping("/deleteItems")
	public ResponseEntity<ResponseStructure<Items>> deleteItems(@Valid@RequestParam int id) {
		return service.deleteItems(id);
	}

	@ApiOperation(value = "Find Items", notes = "API is used to find Items based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Successfully saved"),@ApiResponse(code = 404,message = "ID not found for the given Item id")})
	@GetMapping("/findItemsById")
	public ResponseEntity<ResponseStructure<Items>> findItemsById(@Valid@RequestParam int id) {
		return service.findItemsById(id);
	}
}
