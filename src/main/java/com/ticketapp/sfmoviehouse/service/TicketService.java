package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.model.Event;
import com.ticketapp.sfmoviehouse.model.Ticket;
import com.ticketapp.sfmoviehouse.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Iterable<Ticket> findAll() {
        Iterable<Ticket> tickets = ticketRepository.findAll();
        return tickets;
    }

}
