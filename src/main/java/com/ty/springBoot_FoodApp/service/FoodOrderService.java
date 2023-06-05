package com.ty.springBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.FoodOrderDao;
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.exception.FoodOrderIdNotFoundException;
import com.ty.springBoot_FoodApp.exception.ItemsIdNotFoundException;

@Service
public class FoodOrderService {
	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		List<Items> list = foodOrder.getItems();
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		double totalprice = 0;
		for (Items items : list) {
			totalprice += items.getCost() * items.getQuantity();
			foodOrder.setTotalprice(totalprice);
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("FoodOrder saved successfully");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id) {
		FoodOrder foodOrder2 = dao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if (foodOrder2 != null) {
			List<Items> list = foodOrder2.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();

			}
			foodOrder.setTotalprice(totalprice);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder updated successfully");
			responseStructure.setData(dao.updateFoodOrder(foodOrder, id));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);

		} else {
			throw new FoodOrderIdNotFoundException("FoodOrder Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder foodOrder = dao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder deleted successfully");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFoundException("FoodOrder Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		FoodOrder foodOrder = dao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if (foodOrder != null) {
			List<Items> list = foodOrder.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			}
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FoodOrder found successfully");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new FoodOrderIdNotFoundException("FoodOrder Id not found");
		}
	}

}
