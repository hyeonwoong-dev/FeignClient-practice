package com.nbcamp.course.feign.order.service;

import com.nbcamp.course.feign.order.exception.CustomNotFoundException;
import com.nbcamp.course.feign.order.client.ProductClient;
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
    private final ProductClient productClient;

    public void createOrder(OrderRequestDto request) {

        Long productId = request.getProductId();
        // TODO: Product service 에 productId에 맞는 상품이 있는지 productClient를 사용하여 확인해보세요.

        Order order = Order.create(productId);
        orderRepository.save(order);
    }

    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Order not found"));
        return new OrderResponseDto(order.getId(), order.getProductId());
    }
}
