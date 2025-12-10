package com.webapp.webapp_be.services.orders;

import com.webapp.webapp_be.dto.OrderDTO;
import com.webapp.webapp_be.models.Order;
import com.webapp.webapp_be.models.User;
import com.webapp.webapp_be.repository.OrderRepository;
import com.webapp.webapp_be.repository.UserRepository;
import com.webapp.webapp_be.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with id: " + orderDTO.getUserId()));

        Order newOrder = Order.builder()
                .userId(user)
                .fullName(orderDTO.getFullName())
                .phoneNumber(orderDTO.getPhoneNumber())
                .address(orderDTO.getAddress())
                .note(orderDTO.getNote())
                .noteShip(orderDTO.getNoteShip())
                .shippingMethod(orderDTO.getShippingMethod())
                .totalMoney(orderDTO.getTotalMoney())
                .build();
        return orderRepository.save(newOrder);
    }

    @Override
    public Order updateOrder(Long orderId, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("Cannot find Order with id: "+orderId));
    }

    @Override
    public Page<OrderResponse> getAllOrders(PageRequest pageRequest) {
        Order mapOrder = Order.builder().build();
        return orderRepository
                .findAll(pageRequest)
                .map(OrderResponse::fromOrder);
    }
}
