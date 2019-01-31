package com.baltan.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(value = {TicketConsumerApplication.class})
public class TicketConsumerApplicationTests {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void loadBalanceTest() {
        String serviceId = "ticket-provider";
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = loadBalancerClient.choose(serviceId);
            System.out.println(instance.getUri());
        }
    }

}

