package com.productService.productService.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorRsponse {
	private String errorMessage;
	private String errorCode;

	public ErrorRsponse(String errorMessage, String errorCode) {

		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public ErrorRsponse() {

	}
}
