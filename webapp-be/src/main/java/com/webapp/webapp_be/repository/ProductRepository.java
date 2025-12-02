package com.webapp.webapp_be.repository;

import com.webapp.webapp_be.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
