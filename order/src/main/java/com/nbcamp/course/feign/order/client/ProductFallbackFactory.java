package com.nbcamp.course.feign.order.client;

import com.nbcamp.course.feign.order.model.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class ProductFallbackFactory implements FallbackFactory<ProductClient> {

    @Override
    public ProductClient create(Throwable cause) {
        log.error("Exception", cause);
        return new ProductFallback();
    }
}
