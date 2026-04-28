package com.example.ordersbff.dto.request;

import lombok.Data;

@Data
public class OrderCreateRequest {
    private Long productId;
    private Integer quantity;
    private String deliveryAddress;
}
