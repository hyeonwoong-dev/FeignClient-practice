package com.nbcamp.course.feign.order.service;

import com.nbcamp.course.feign.order.model.OrderRequestDto;
import com.nbcamp.course.feign.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void createOrder(OrderRequestDto request) {
        // TODO: Product service 에 productId에 맞는 상품이 있는지 확인
        // TODO: Order 객체 생성
    }
}
