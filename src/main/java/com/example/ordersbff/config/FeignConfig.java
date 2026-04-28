package com.example.ordersbff.config;

import com.example.ordersbff.service.client.OrderFeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new OrderFeignErrorDecoder();
    }
}
