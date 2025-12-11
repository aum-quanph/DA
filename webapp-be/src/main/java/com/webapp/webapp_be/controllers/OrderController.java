package com.webapp.webapp_be.controllers;

import com.webapp.webapp_be.dto.OrderDTO;
import com.webapp.webapp_be.models.Order;
import com.webapp.webapp_be.response.OrderResponse;
import com.webapp.webapp_be.services.orders.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order newOrder = orderService.createOrder(orderDTO);
            return ResponseEntity.ok(newOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Long orderId, @RequestBody OrderDTO orderDTO) {
        try {
            Order updateOrder = orderService.updateOrder(orderId, orderDTO);
            return ResponseEntity.ok(String.format("Update Order with id = %d successful", orderId));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long orderId) {
        try {
            Order order = orderService.getOrderById(orderId);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<Page<OrderResponse>> getAllOrders(PageRequest pageRequest) {
        try {
            Page<OrderResponse> orders = orderService.getAllOrders(pageRequest);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



}
