package com.example.ordersbff.service.client;

import com.example.ordersbff.dto.request.OrderCreateRequest;
import com.example.ordersbff.dto.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order-ms", url = "${feign.client.order-ms.url}")
public interface OrderClient {

    @PostMapping("/v1/orders")
    OrderResponse createOrder(
            @RequestHeader("X-User-Id") Long userId,
            @RequestBody OrderCreateRequest request
    );

    @GetMapping("/v1/orders/{id}")
    OrderResponse getOrderById(@PathVariable Long id);

    @PostMapping("/v1/orders/{orderId}/cancel")
    OrderResponse cancelOrder(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long orderId
    );
}
