package com.ty.springBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.repo.ItemRepo;

@Repository
public class ItemDao {
	
	@Autowired
	private ItemRepo repo;
	
	public Items saveItems(Items items) {
		return repo.save(items);
	}
	
	public Items updateItems(Items items,int id) {
		Optional<Items> items2= repo.findById(id);
		if(items2.isPresent()) {
			items.setItem_id(id);
			repo.save(items);
			return items2.get();
		}
		else {
			return null;
		}
	}
	
	public Items deleteItems(int id) {
		Optional<Items> items=repo.findById(id);
		if(items.isPresent()) {
			repo.deleteById(id);;
			return items.get();
		}
		else {
			return null;
		}
	}
	
	public Items findItemsById(int id) {
		Optional<Items> items= repo.findById(id);
		if(items.isPresent()) {
			return items.get();
		}
		else {
			return null;
		}
	}
	
	
}
