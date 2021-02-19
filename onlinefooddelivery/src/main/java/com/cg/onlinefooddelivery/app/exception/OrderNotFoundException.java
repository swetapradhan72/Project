package com.cg.onlinefooddelivery.app.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6420668789683694158L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String errMsg) {
		super(errMsg);
	}
}
