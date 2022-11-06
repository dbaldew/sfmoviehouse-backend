package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.TicketDTO;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        var tickets = ticketService.findAllTickets()
                .stream().map(TicketDTO::fromTicket)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable Long id) {
        var ticket = TicketDTO.fromTicket(ticketService.findTicketById(id));
        return ResponseEntity.ok(ticket);
    }


    @PostMapping(value = "")
    public ResponseEntity<Object> addTicket(@RequestBody TicketDTO ticketDTO) {
        Ticket newTicket = ticketService.save(ticketDTO.toTicket());
        Long id = newTicket.getTicketID();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok("removed ticket");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        var updatedTicket = ticketDTO.toTicket();
        ticketService.updateTicket(id, updatedTicket );
        return ResponseEntity.noContent().build();
    }
}
