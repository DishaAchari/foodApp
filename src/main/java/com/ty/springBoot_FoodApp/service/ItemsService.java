package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ItemDao;
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.exception.ItemsIdNotFoundException;
import com.ty.springBoot_FoodApp.exception.ItemsNotFoundException;

@Service
public class ItemsService {

	@Autowired
	private ItemDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Item saved successfully");
		responseStructure.setData(dao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int id) {
		Items items2 = dao.updateItems(items, id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if (items2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Item updated successfully");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ItemsNotFoundException("Items not found");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItems(int id) {
		Items items = dao.deleteItems(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if (items != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Item deleted successfully");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ItemsIdNotFoundException("Items Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> findItemsById(int id) {
		Items items = dao.findItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if (items != null) {

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Item found successfully");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new ItemsIdNotFoundException("Items Id not found");
		}
	}

}
