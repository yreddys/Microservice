package com.productService.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productService.productService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
