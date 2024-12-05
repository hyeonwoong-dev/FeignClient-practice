package com.nbcamp.course.feign.order.service;

import com.nbcamp.course.feign.order.exception.CustomNotFoundException;
import com.nbcamp.course.feign.order.model.Order;
import com.nbcamp.course.feign.order.model.OrderRequestDto;
import com.nbcamp.course.feign.order.model.OrderResponseDto;
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

    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Order not found"));
        return new OrderResponseDto(order.getId(), order.getProductId());
    }
}
