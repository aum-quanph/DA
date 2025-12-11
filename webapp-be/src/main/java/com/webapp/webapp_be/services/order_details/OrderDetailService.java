package com.webapp.webapp_be.services.order_details;

import com.webapp.webapp_be.dto.OrderDetailDTO;
import com.webapp.webapp_be.models.Order;
import com.webapp.webapp_be.models.OrderDetail;
import com.webapp.webapp_be.models.Product;
import com.webapp.webapp_be.repository.OrderRepository;
import com.webapp.webapp_be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailService implements IOrderDetailService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) {
        Order order = orderRepository.findById(orderDetailDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Cannot find order by id: " + orderDetailDTO.getOrderId()));

        Product product = productRepository.findById(orderDetailDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Cannot find product by id: " + orderDetailDTO.getProductId()));

        OrderDetail newOrderDetail = OrderDetail.builder()
                .orderId(order)
                .productId(product)
                .price(orderDetailDTO.getPrice())
                .numberOfProduct(orderDetailDTO.getNumberOfProduct())
                .totalMoney(orderDetailDTO.getTotalMoney())
                .build();
        return newOrderDetail;
    }

    @Override
    public OrderDetail updateOrderDetail(Long orderDetailId, OrderDetailDTO orderDetailDTO) {
        return null;
    }

    @Override
    public void getOrderDetailById(Long orderDetailId) {

    }
}
