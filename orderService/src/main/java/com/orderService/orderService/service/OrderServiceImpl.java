package com.orderService.orderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderService.orderService.entity.Order;
import com.orderService.orderService.external.client.ProductService;
import com.orderService.orderService.model.OrderRequest;
import com.orderService.orderService.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;

	@Autowired
	OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;

	}

	@Autowired
	private ProductService productService;

	@Override
	public long placeOrder(OrderRequest orderRequest) {
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("Creating Order with Status CREATED");
		Order order = Order.builder().amount(orderRequest.getTotalAmount()).orderDate(Instant.now())
				.orderStatus("CREATED").productId(orderRequest.getProductId()).quantity(orderRequest.getQuantity())
				.build();
		order = orderRepository.save(order);
		log.info("Order placed :{}", order);
		return order.getId();
	}
}
