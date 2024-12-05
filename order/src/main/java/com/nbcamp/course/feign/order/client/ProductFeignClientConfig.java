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
        // TODO: RequestInterceptor 를 활용해서 해당 client의 모든 요청에서 들어가야 하는 헤더 값을 설정해보세요.
        return requestTemplate -> {
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        // TODO: 생성한 CustomErrorDecoder를 Bean 으로 등록해보세요.
        return null;
    }

    @Bean
    public Retryer retryer() {
        // TODO: Retryer 를 만들고 period, max_period, attempt 등을 설정해서 재시도 간격을 조절해보세요.
        return null;
    }
}
