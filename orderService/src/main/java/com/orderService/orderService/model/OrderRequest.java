package com.orderService.orderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
	private long productId;
	private long quantity;
	private PaymentMode paymentMode;
	private long totalAmount;
}
