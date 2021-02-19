package com.cg.onlinefooddelivery.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<Object> handleProjectException(OrderNotFoundException e,WebRequest request){
		ExceptionResponse response=new ExceptionResponse(e.getMessage());
		return new  ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleProjectException(ItemNotFoundException e,WebRequest request){
		ExceptionResponse response=new ExceptionResponse(e.getMessage());
		return new  ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
		
	}
	
}
