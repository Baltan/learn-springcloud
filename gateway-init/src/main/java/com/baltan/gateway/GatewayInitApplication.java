package com.baltan.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayInitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayInitApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        /**
                         * 为请求添加一个header,key为"hello"，value为"world"。
                         */
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        /**
                         * 对"http://localhost:8080/get"的请求会被路由到"http://httpbin.org/get"
                         */
                        .uri("http://httpbin.org:80"))
                .build();
    }
}
