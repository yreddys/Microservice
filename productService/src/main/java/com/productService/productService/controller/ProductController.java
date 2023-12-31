package com.productService.productService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productService.productService.model.ProductRequest;
import com.productService.productService.model.ProductResponse;
import com.productService.productService.service.ProductService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController {
	private ProductService productService;

	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/save")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		long prodcutId = productService.addProduct(productRequest);
		return new ResponseEntity<>(prodcutId, HttpStatus.CREATED);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) {
		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity) {
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
