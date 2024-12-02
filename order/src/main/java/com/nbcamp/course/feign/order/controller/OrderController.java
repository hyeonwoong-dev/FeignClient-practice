package com.nbcamp.course.feign.order.controller;

import com.nbcamp.course.feign.order.model.OrderRequestDto;
import com.nbcamp.course.feign.order.model.OrderResponseDto;
import com.nbcamp.course.feign.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public void create(@RequestBody OrderRequestDto request) {
        orderService.createOrder(request);
    }

    @GetMapping("/orders/{id}")
    public OrderResponseDto getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }
}
