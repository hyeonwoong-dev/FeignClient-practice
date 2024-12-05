package com.nbcamp.course.feign.order.client;

import com.nbcamp.course.feign.order.exception.CustomBadRequestException;
import com.nbcamp.course.feign.order.exception.CustomNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;


public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new CustomBadRequestException("Custom Bad Request in feignClient request");
            case 404 -> new CustomNotFoundException("There is no resource");
            default -> new RuntimeException("Unknown error");
        };
    }
}