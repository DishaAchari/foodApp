package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.MenuDao;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.exception.MenuIdNotFoundException;
import com.ty.springBoot_FoodApp.exception.MenuNotFoundException;
import com.ty.springBoot_FoodApp.exception.ProductIdNotFoundException;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Menu saved successfully");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id) {
		Menu menu2 = dao.updateMenu(menu, id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu updated successfully");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);

		} else {
			throw new MenuNotFoundException("Menu Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		Menu menu = dao.deleteMenu(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		if (menu != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu deleted successfully");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		} else {
			throw new MenuIdNotFoundException("Menu Id is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {		
		Menu menu = dao.getMenuById(id);
	ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
	if (menu != null) {

		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Menu found successfully");
		responseStructure.setData(menu);
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new MenuIdNotFoundException("Menu Id is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuByMenu(String mname) {
		Menu menu = dao.getMenuByName(mname);
	ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
	if (menu != null) {

		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Menu found successfully");
		responseStructure.setData(menu);
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);
		} else {
			return null;
		}
	}

}
