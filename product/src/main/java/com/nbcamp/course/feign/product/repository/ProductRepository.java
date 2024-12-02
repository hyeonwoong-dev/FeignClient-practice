package com.nbcamp.course.feign.product.repository;

import com.nbcamp.course.feign.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
