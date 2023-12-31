package com.productService.productService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceCustomExceptionHandler {
	@ExceptionHandler(ProductServiceCustomException.class)
	ResponseEntity<ErrorRsponse> handlingException(ProductServiceCustomException ex) {

		return new ResponseEntity<>(
				new ErrorRsponse().builder().errorCode(ex.getErrorCode()).errorMessage(ex.getMessage()).build(),
				HttpStatus.NOT_FOUND);

	}
}
