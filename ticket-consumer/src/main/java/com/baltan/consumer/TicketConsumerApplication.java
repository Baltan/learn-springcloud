package com.baltan.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class TicketConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketConsumerApplication.class, args);
    }

    /**
     * RestTemplate底层是通过JDK的http相关的API实现的，可以通过配置修改为HttpClient或者OKHttp的实现方式
     *
     * @return
     */
    @Bean
    @LoadBalanced // 添加@LoadBalanced后发HTTP请求时可以使用负载均衡机制
    public RestTemplate restTemplate() {
//        return new RestTemplate();
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

}

