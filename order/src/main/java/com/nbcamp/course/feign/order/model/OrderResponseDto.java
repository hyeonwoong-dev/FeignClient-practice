package com.nbcamp.course.feign.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private Long productId;
}
