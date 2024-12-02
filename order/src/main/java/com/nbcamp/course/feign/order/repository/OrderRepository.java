package com.nbcamp.course.feign.order.repository;

import com.nbcamp.course.feign.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
