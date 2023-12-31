package com.productService.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ProductResponse {

	private String productName;
	private long productId;
	private long quantity;
	private long price;

	public ProductResponse(String productName, long productId, long quantity, long price) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public ProductResponse() {
		
	}

}
