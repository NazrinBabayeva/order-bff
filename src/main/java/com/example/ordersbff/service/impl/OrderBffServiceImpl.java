package com.example.ordersbff.service.impl;

import com.example.ordersbff.dto.request.OrderCreateRequest;
import com.example.ordersbff.dto.response.OrderResponse;
import com.example.ordersbff.service.OrderBffService;
import com.example.ordersbff.service.client.OrderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderBffServiceImpl implements OrderBffService {

    private final OrderClient orderClient;

    @Override
    public OrderResponse createOrder(Long userId, OrderCreateRequest request) {
        return orderClient.createOrder(userId, request);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return orderClient.getOrderById(id);
    }

    @Override
    public OrderResponse cancelOrder(Long userId, Long orderId) {
        return orderClient.cancelOrder(userId, orderId);
    }
}
