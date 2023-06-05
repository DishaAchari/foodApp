package com.ty.springBoot_FoodApp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ProductDao;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.exception.ProductIdNotFoundException;
import com.ty.springBoot_FoodApp.exception.ProductNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product updated successfully");
		responseStructure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		Product product2 = dao.updateProduct(id, product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if (product2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product updated successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else

		{
			throw new ProductNotFoundException("Product Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product product = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Product found successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ProductIdNotFoundException("Product Id is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product product = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product deleted successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Product Id is Not Present");
		}
	}
	
}
