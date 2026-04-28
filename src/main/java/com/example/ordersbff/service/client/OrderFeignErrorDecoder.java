package com.example.ordersbff.service.client;

import com.example.ordersbff.exception.ConflictException;
import com.example.ordersbff.exception.InternalServerErrorException;
import com.example.ordersbff.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        HttpStatus status = HttpStatus.resolve(response.status());

        switch (response.status()) {

            case 400:
                return new BadRequestException("Order MS - Bad Request");

            case 404:
                return new NotFoundException("Order MS - Resource not found");

            case 409:
                return new ConflictException("Order MS - Conflict");

            case 500:
                return new InternalServerErrorException("Order MS crashed");

            default:
                return new RuntimeException(
                        "Order-MS error: " + response.status()
                );
        }
    }
}
