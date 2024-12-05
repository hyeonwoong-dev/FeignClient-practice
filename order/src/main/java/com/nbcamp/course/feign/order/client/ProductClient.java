package com.nbcamp.course.feign.order.client;

import com.nbcamp.course.feign.order.model.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "product"
        // TODO: FeignClient config를 적용해보세요.
        // TODO: Fallback 클래스를 적용해보세요.
)
public interface ProductClient {

    // TODO: 다양한 방법으로 header를 입력하고 확인해보세요.
    @GetMapping(value="/products/{id}")
    ProductResponseDto getProduct(@PathVariable("id") Long id);
}
