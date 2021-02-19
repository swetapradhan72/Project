package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlinefooddelivery.app.domain.FoodCart;
@Repository
public interface FoodCartRepository extends CrudRepository<FoodCart,Integer>{

     FoodCart findById(int id);
}
