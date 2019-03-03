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

        String httpUri = "http://httpbin.org:80";

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
                        .uri(httpUri))
                /**
                 * 使用host去断言请求是否进入该路由，当请求的host有“*.hystrix.com”，都会进入该router，
                 * 该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，
                 * 比如本案例中重定向到了“/fallback”。
                 */
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }
}
