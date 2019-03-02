package com.baltan.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-01-25 14:35
 */
@Component
public class TicketService {

    @HystrixCommand(fallbackMethod = "getTicketError")
    public String getTicket() {
        return "电影票：《3D肉蒲团》";
    }

    public String getTicketError() {
        return "error!";
    }
}
