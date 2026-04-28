package com.example.ordersbff.service;

import com.example.ordersbff.dto.request.OrderCreateRequest;
import com.example.ordersbff.dto.response.OrderResponse;

public interface OrderBffService {

    OrderResponse createOrder(Long userId, OrderCreateRequest request);

    OrderResponse getOrderById(Long id);

    OrderResponse cancelOrder(Long userId, Long orderId);


}
