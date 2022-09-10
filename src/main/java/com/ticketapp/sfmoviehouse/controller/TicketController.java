package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Ticket;
import com.ticketapp.sfmoviehouse.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {


    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("")
    public ResponseEntity <Object>getTickets() {
        return ResponseEntity.ok().body(ticketService.findAll());

    }
    @GetMapping(value = "{id}")
    public ResponseEntity <Object>getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity <Object>addTicket(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
        return ResponseEntity.ok("added ticket");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity <Object>deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok("removed ticket");
    }
    @PutMapping(value = "{id}")
    public ResponseEntity updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticketService.updateTicket(id, ticket);
        return ResponseEntity.ok("updated ticket");
    }
}
