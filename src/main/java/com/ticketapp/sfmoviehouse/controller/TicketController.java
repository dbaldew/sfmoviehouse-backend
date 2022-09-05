package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Ticket;
import com.ticketapp.sfmoviehouse.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity getTicket() {
        Iterable<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok(tickets);

    }

}
