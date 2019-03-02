package com.baltan.consumer.controller;

import com.baltan.consumer.feign.ConsumerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private ConsumerFeignClient consumerFeignClient;

//    @Value("${provider.url}")
//    private String url;

    @GetMapping("/buyTicket/{name}")
    @HystrixCommand(fallbackMethod = "buyTicketError")
    public String buyTicket(@PathVariable("name") String name) {

//        String ticketName = restTemplate.getForObject(url + "getTicket", String.class);
//        return name + "购买了" + ticketName;

//        String serviceId = "ticket-provider";
//        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
//        if (instances == null || instances.isEmpty()) {
//            return null;
//        }
//        ServiceInstance instance = instances.get(0);
        /**
         * RestTemplate Bean添加@LoadBalanced注解后，在调用getForObject()
         * 方法时，会先根据传入的serviceId找到注册中心中所有可用的服务，再根据内部算法选择一个ip进行访问，实现负载均衡
         */
//        String url = "http://" + serviceId + "/getTicket";
        /**
         * 这种方式不用将服务url写进配置文件，解决了多个服务url的问题
         * 不能直接访问服务的ip，只能访问服务注册在eureka注册中心的application.name
         */
//        String ticketName = restTemplate.getForObject(url, String.class);

        String ticketName = consumerFeignClient.getTicket();
        return name + "购买了" + ticketName;
    }


    public String buyTicketError(String name) {
        return "error!";
    }
}
