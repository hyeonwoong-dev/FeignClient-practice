package com.nbcamp.course.feign.order.client;

import feign.Logger;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ProductFeignClientConfig {
    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.HEADERS;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("server-port", serverPort);
            requestTemplate.header("USER-ROLE", "CUSTOMER");
            requestTemplate.header("INTERNAL-KEY", "something key");
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 300000, 5);
    }
}
