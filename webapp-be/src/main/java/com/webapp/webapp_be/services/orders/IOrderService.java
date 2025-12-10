package com.webapp.webapp_be.services.orders;

import com.webapp.webapp_be.dto.OrderDTO;
import com.webapp.webapp_be.models.Order;
import com.webapp.webapp_be.response.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;

public interface IOrderService {
    Order createOrder(OrderDTO orderDTO);
    Order updateOrder(Long orderId, OrderDTO orderDTO);
    Order getOrderById(Long orderId);
    Page<OrderResponse> getAllOrders(PageRequest pageRequest);
}
