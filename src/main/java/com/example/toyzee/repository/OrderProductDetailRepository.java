package com.example.toyzee.repository;

import com.example.toyzee.model.OrderProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDetailRepository extends JpaRepository<OrderProductDetail, Long> {
}