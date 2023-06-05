package com.ty.springBoot_FoodApp.repo;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Items;

public interface ItemRepo extends JpaRepository<Items, Integer>{

}
