package com.webapp.webapp_be.repository;

import com.webapp.webapp_be.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
