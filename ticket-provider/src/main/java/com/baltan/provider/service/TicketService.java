package com.baltan.provider.service;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-01-25 14:35
 */
@Component
public class TicketService {

    public String getTicket() {
        return "电影票：《3D肉蒲团》";
    }
}
