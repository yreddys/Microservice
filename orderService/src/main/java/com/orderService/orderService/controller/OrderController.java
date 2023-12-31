package com.orderService.orderService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.orderService.model.OrderRequest;
import com.orderService.orderService.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
	private OrderService orderService;

	OrderController(OrderService orderService) {

		this.orderService = orderService;
	}

	@PostMapping("/save")
	ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
		long orderId = orderService.placeOrder(orderRequest);
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}

}
