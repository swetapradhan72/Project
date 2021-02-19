package com.cg.onlinefooddelivery.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.serviceimpl.ItemServiceImpl;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;

@RestController
@RequestMapping("/ofd/api/foodcart")
public class FoodCartController {

	@Autowired
	private MapValidationServiceImpl mapValidationServiceImpl;
	
	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> addToCart(@Valid @RequestBody Item item, BindingResult result,@PathVariable int id) {
		ResponseEntity<?> errorMap=mapValidationServiceImpl.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Item item1=itemServiceImpl.saveItem(item,id);
		return new ResponseEntity<Item>(item1,HttpStatus.OK);
	}
	
	
}
