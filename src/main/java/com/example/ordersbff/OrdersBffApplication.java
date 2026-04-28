package com.example.ordersbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdersBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersBffApplication.class, args);
    }

}
