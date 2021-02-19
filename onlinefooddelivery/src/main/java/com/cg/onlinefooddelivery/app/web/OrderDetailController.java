package com.cg.onlinefooddelivery.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.OrderDetail;
import com.cg.onlinefooddelivery.app.exception.OrderNotFoundException;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;
import com.cg.onlinefooddelivery.app.serviceimpl.OrderDetailServiceImpl;


@RestController
@RequestMapping("/ofd/api/orderdetail")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailServiceImpl orderDetailServiceImpl;
	
	@Autowired
	private MapValidationServiceImpl mapValidationServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> addOrderDetail(@Valid @RequestBody OrderDetail orderDetail, BindingResult result) throws OrderNotFoundException {
		ResponseEntity<?> errorMap=mapValidationServiceImpl.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		OrderDetail order=orderDetailServiceImpl.SaveOrUpdate(orderDetail);
		return new ResponseEntity<OrderDetail>(order,HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}")
	public OrderDetail findOrderDetail(@PathVariable int id) throws OrderNotFoundException {
		OrderDetail order= orderDetailServiceImpl.findById(id);
		return order;
		
	}
	
	@GetMapping("/all")
	public Iterable<OrderDetail> getAllOrders(){
		return orderDetailServiceImpl.getAllOrderDetails(); 
	}
	@DeleteMapping("/{id}")
	public void deleteOrderDetail(@PathVariable int id) throws OrderNotFoundException {
		orderDetailServiceImpl.deleteOrderDetailsById(id);
		
	}

}
