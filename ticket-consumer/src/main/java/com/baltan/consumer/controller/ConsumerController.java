package com.baltan.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-01-25 14:54
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Value("${provider.url}")
//    private String url;

    @GetMapping("/buyTicket/{name}")
    public String buyTicket(@PathVariable("name") String name) {

//        String ticketName = restTemplate.getForObject(url + "getTicket", String.class);
//        return name + "购买了" + ticketName;

        String serviceId = "ticket-provider";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getServiceId() + "/getTicket";
        /**
         * 这种方式不用将服务url写进配置文件，解决了多个服务url的问题
         * 不能直接访问服务的ip，只能访问服务注册在eureka注册中心的application.name
         */
        String ticketName = restTemplate.getForObject(url, String.class);
        return name + "购买了" + ticketName;
    }
}
