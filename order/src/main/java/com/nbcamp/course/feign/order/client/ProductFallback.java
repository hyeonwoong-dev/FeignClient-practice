package com.nbcamp.course.feign.order.client;

import com.nbcamp.course.feign.order.model.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductFallback implements ProductClient {
    @Override
    public ProductResponseDto getProduct(Long id, String header) {
        return new ProductResponseDto();
    }
}
