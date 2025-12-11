package com.webapp.webapp_be.services.order_details;

import com.webapp.webapp_be.dto.OrderDetailDTO;
import com.webapp.webapp_be.models.OrderDetail;

public interface IOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO);
    OrderDetail updateOrderDetail(Long orderDetailId, OrderDetailDTO orderDetailDTO);
    OrderDetail getOrderDetailById(Long orderDetailId);
}
