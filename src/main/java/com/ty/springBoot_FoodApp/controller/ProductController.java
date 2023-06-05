package com.ty.springBoot_FoodApp.controller;

import java.util.List;

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
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

		@Autowired
	private ProductService service;
		
		@ApiOperation(value = "Save Product", notes = "API is used to save product based on id")
		@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully saved"),@ApiResponse(code = 400,message = "ID not found for the given product id")})
		@PostMapping("/saveProduct")
		public ResponseEntity<ResponseStructure<Product>> saveProduct(@Valid@RequestBody Product product) {
			return service.saveProduct(product);
		}
		
		@ApiOperation(value = "Update Product", notes = "API is used to update product based on id")
		@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully updated"),@ApiResponse(code = 400,message = "ID not found for the given product id")})
		@PutMapping("/updateProduct")
		public ResponseEntity<ResponseStructure<Product>> updateProduct(@Valid@RequestParam int id,@RequestBody Product product) {
			return service.updateProduct(id, product);
		}
		
		@ApiOperation(value = "Get Product", notes = "API is used to get product based on id")
		@ApiResponses(value = {@ApiResponse(code=302,message = "Successfully found"),@ApiResponse(code = 404,message = "ID not found for the given product id")})
		@GetMapping("/getProductById")
		public ResponseEntity<ResponseStructure<Product>> getProductById(@Valid@RequestParam int id) {
			return service.getProductById(id);
		}
		
		@ApiOperation(value = "Delete Product", notes = "API is used to delete product based on id")
		@ApiResponses(value = {@ApiResponse(code=200,message = "Successfully deleted"),@ApiResponse(code = 400,message = "ID not found for the given product id")})
		@DeleteMapping("/deleteProduct")
		public ResponseEntity<ResponseStructure<Product>> deleteProduct(@Valid @RequestParam int id) {
			return service.deleteProduct(id);
		}
		
		
}
