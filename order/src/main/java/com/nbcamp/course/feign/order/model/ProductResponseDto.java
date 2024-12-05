package com.nbcamp.course.feign.order.model;

import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private int price;
}
