package com.baltan.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Value("${provider.url}")
    private String url;

    @GetMapping("/buyTicket/{name}")
    public String buyTicket(@PathVariable("name") String name) {

        String ticketName = restTemplate.getForObject(url + "getTicket", String.class);
        return name + "购买了" + ticketName;
    }
}
