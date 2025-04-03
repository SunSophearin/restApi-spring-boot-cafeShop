package com.cafeShop.cafe.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ErrorRespone {
	private HttpStatus httpStatus;
	private String message;
}
