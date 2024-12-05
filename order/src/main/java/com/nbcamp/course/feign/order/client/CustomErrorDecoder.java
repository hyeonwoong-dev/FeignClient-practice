package com.nbcamp.course.feign.order.client;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // TODO: response status 에 따라서 구체적인 예외를 발생시켜 보세요.
        // TODO: RetryableException 을 발생시켜 재시도 로직을 구현해보세요.
        return null;
    }
}