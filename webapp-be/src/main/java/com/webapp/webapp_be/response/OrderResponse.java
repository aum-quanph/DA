package com.webapp.webapp_be.response;

import com.webapp.webapp_be.models.Order;
import lombok.Builder;

@Builder
public class OrderResponse {
    public static OrderResponse fromOrder(Order order) {
        OrderResponse orderResponse = OrderResponse.builder().build();
        return orderResponse;
    }
}
