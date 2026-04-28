package com.example.ordersbff.controller;

import com.example.ordersbff.dto.request.OrderCreateRequest;
import com.example.ordersbff.dto.response.OrderResponse;
import com.example.ordersbff.service.OrderBffService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderBffController {

    private final OrderBffService orderBffService;

    @PostMapping
    public OrderResponse create(@RequestHeader("X-User-Id") Long userId,
                                @RequestBody OrderCreateRequest dto) {

        return orderBffService.createOrder(userId, dto);
    }

    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id) {
        return orderBffService.getOrderById(id);
    }

    @PostMapping("/{orderId}/cancel")
    public OrderResponse cancelOrder(HttpServletRequest request,
                                     @PathVariable Long orderId) {

        Long userId = Long.valueOf(request.getAttribute("userId").toString());

        return orderBffService.cancelOrder(userId, orderId);
    }
}
