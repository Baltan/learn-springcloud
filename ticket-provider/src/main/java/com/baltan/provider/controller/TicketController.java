package com.baltan.provider.controller;

import com.baltan.provider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-01-25 14:38
 */
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getTicket")
    public String getTicket() {
        return ticketService.getTicket();
    }
}
