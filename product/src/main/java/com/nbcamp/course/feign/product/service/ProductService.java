package com.nbcamp.course.feign.product.service;

import com.nbcamp.course.feign.product.model.Product;
import com.nbcamp.course.feign.product.model.ProductResponseDto;
import com.nbcamp.course.feign.product.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @PostConstruct
    private void init() {
        for (int i = 0; i < 10; i++) {
            Product product = Product.create("product " + i, 1000 * i);
            productRepository.save(product);
        }
    }

    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponseDto(product.getId(), product.getName(), product.getPrice());
    }
}
