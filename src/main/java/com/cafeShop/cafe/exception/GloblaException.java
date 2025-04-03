package com.cafeShop.cafe.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloblaException {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> exception(ApiException e){
		ErrorRespone errorRespone=new ErrorRespone(e.getHttpStatus(), e.getMessage());
		return ResponseEntity.status(e.getHttpStatus()).body(errorRespone);
	}
}
