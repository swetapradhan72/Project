package com.cg.onlinefooddelivery.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.repository.FoodCartRepository;
import com.cg.onlinefooddelivery.app.repository.ItemRepository;
@Service
public class ItemServiceImpl {

	@Autowired
	private ItemRepository itemRepository;
	
    @Autowired
    private FoodCartRepository cartRepository;
	
	public Item saveItem(Item item,int id) {
		FoodCart cart=cartRepository.findById(id);
		item.setFoodCart(cart);
		return itemRepository.save(item);
	}
	
	public Item findById(int id) {
		Item item=itemRepository.findById(id);
		return item;
	}
	public void deleItembyId(int id) {
		Item item=itemRepository.findById(id);
		itemRepository.deleteById(id);
	}
	public Iterable<Item> findAlld() {
		return itemRepository.findAll();
	 
	}
}
