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

    @GetMapping("username/{username}")
    public ResponseEntity<List<TicketDTO>> getAllTicketsByUser(@PathVariable String username) {
        var tickets = ticketService.findAllTicketsByUser(username)
                .stream().map(TicketDTO::fromTicket)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("movieid/{movieID}")
    public ResponseEntity<List<TicketDTO>> getAllTicketsByTitle(@PathVariable Long movieID) {
        var tickets = ticketService.findAllTicketsByMovieID(movieID)
                .stream().map(TicketDTO::fromTicket)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping(value = "id{id}")
    public ResponseEntity<TicketDTO> getTicketByID(@PathVariable Long id) {
        var ticket = TicketDTO.fromTicket(ticketService.findById(id));
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

    @DeleteMapping(value = "id/{id}")
    public ResponseEntity<Object> deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok("removed ticket");
    }

    @PutMapping(value = "id{id}")
    public ResponseEntity<Object> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        ticketService.updateTicket(id, ticketDTO.toTicket());
        return ResponseEntity.noContent().build();
    }
}
