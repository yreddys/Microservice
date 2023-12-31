package com.productService.productService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.productService.productService.entity.Product;
import com.productService.productService.exception.ProductServiceCustomException;
import com.productService.productService.model.ProductRequest;
import com.productService.productService.model.ProductResponse;
import com.productService.productService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;

	ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding product ..:{}", productRequest);
		Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
				.price(productRequest.getPrice()).build();
		productRepository.save(product);
		log.info("product created:{}", product);
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("get the product for the product id :{}", productId);
		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("product with given id not found", "product_notfound"));
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		log.info("Reduced Quantity:{}", quantity, productId);
		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("product with given id not found", "product_notfound"));
		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("product does not have sufficient quantity", "Insufficient_quantity");

		}
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
		log.info("Product Quantity updated Successfully");
	}
}
