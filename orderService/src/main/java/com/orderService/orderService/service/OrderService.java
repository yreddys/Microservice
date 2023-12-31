package com.orderService.orderService.service;

import com.orderService.orderService.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
