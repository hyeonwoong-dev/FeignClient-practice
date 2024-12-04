package com.nbcamp.course.feign.order.service;

import com.nbcamp.course.feign.order.client.ProductClient;
import com.nbcamp.course.feign.order.model.Order;
import com.nbcamp.course.feign.order.model.OrderRequestDto;
import com.nbcamp.course.feign.order.model.OrderResponseDto;
import com.nbcamp.course.feign.order.model.ProductResponseDto;
import com.nbcamp.course.feign.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public void createOrder(OrderRequestDto request) {
        // TODO: Product service 에 productId에 맞는 상품이 있는지 확인
        Long productId = request.getProductId();

        try {
            ProductResponseDto product = productClient.getProduct(productId, "newHeader");
        } catch (Exception e) {
            throw new RuntimeException("Product not found");
        }

        // TODO: Order 객체 생성
        Order order = Order.create(productId);
        orderRepository.save(order);
    }

    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderResponseDto(order.getId(), order.getProductId());
    }
}
