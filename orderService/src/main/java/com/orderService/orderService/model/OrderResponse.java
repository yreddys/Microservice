package com.orderService.orderService.model;

import java.time.Instant;

import lombok.Data;
@Data
public class OrderResponse {
	private long id;
	private long productId;
	private long quantity;
	private Instant orderDate;
	private String orderStatus;
	private long amount;
}
