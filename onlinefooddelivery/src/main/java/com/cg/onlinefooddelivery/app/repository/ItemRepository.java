package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item,Integer>{
	Item findById(int id);
	
}
