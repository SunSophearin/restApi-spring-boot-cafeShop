package com.cafeShop.cafe.exception;

import org.springframework.http.HttpStatus;

public class ResoureExceptionNotFound extends ApiException {

	public ResoureExceptionNotFound( String message,Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s With ID = %d NOT_FOUND", message,id));
	}

}
