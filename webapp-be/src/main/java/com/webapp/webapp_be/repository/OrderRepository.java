package com.webapp.webapp_be.repository;

import com.webapp.webapp_be.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
