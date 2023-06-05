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
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.service.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@ApiOperation(value = "Save Menu", notes = "API is used to save menu based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given Menu id")})
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@Valid@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}
	
	@ApiOperation(value = "Update Menu", notes = "API is used to update menu based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given Menu id")})
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@Valid@RequestBody Menu menu,@RequestParam int id) {
		return service.updateMenu(menu,id);
	}
	
	@ApiOperation(value = "Delete Menu", notes = "API is used to delete menu based on id")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully deleted"),@ApiResponse(code = 400,message = "ID not found for the given Menu id")})
	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@Valid@RequestParam int id) {
		return service.deleteMenu(id);
	}
	
	@ApiOperation(value = "Get Menu", notes = "API is used to get menu based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Successfully found"),@ApiResponse(code = 404,message = "ID not found for the given Menu id")})
	@GetMapping("/getMenuById")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@Valid@RequestParam int id) {
		return service.getMenuById(id);
	}
	
	@ApiOperation(value = "Get Menu by name", notes = "API is used to get menu based on name")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Successfully found"),@ApiResponse(code = 404,message = "Menu not found for the given Menu name")})
	@GetMapping("/getMenuByName")
	public ResponseEntity<ResponseStructure<Menu>> getMenuByMname(@Valid@RequestParam String mname) {
		return service.getMenuByMenu(mname);
	}
}
