package com.nbcamp.course.feign.product.controller;

import com.nbcamp.course.feign.product.model.ProductResponseDto;
import com.nbcamp.course.feign.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
