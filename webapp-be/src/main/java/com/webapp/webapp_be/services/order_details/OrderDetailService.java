package com.webapp.webapp_be.services.order_details;

import com.webapp.webapp_be.dto.OrderDetailDTO;
import com.webapp.webapp_be.models.Order;
import com.webapp.webapp_be.models.OrderDetail;
import com.webapp.webapp_be.models.Product;
import com.webapp.webapp_be.repository.OrderDetailRepository;
import com.webapp.webapp_be.repository.OrderRepository;
import com.webapp.webapp_be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailService implements IOrderDetailService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;

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
        OrderDetail existingOrderDetail = orderDetailRepository.findById(orderDetailId)
                .orElseThrow(() -> new RuntimeException("Cannot find order detail with id: "+orderDetailId));
        Order existingOrder = orderRepository.findById(orderDetailDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Cannot find order with id: "+orderDetailId));
        Product existingProduct = productRepository.findById(orderDetailDTO.getProductId())
                .orElseThrow(() -> new RuntimeException(
                        "Cannot find product with id: " + orderDetailDTO.getProductId()));
        existingOrderDetail.setPrice(orderDetailDTO.getPrice());
        existingOrderDetail.setNumberOfProduct(orderDetailDTO.getNumberOfProduct());
        existingOrderDetail.setTotalMoney(orderDetailDTO.getTotalMoney());
        existingOrderDetail.setOrderId(existingOrder);
        existingOrderDetail.setProductId(existingProduct);
        return orderDetailRepository.save(existingOrderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(Long orderDetailId) {
        return orderDetailRepository.findById(orderDetailId)
                .orElseThrow(()->new RuntimeException("Cannot find OrderDetail with id: "+orderDetailId));
    }
}
