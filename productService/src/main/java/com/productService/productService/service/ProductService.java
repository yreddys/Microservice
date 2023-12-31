package com.productService.productService.service;

import com.productService.productService.model.ProductRequest;
import com.productService.productService.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceQuantity(long productId, long quantity);

}
