package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.model.Ticket;
import com.ticketapp.sfmoviehouse.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Ticket> findById(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return ticketRepository.findById(id);
    }

    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteById(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        ticketRepository.deleteById(id);
    }
    public void updateTicket(Long id, Ticket updatedTicket){
        if(!ticketRepository.existsById(id)){
            throw new RecordNotFoundException();
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setDate(updatedTicket.getDate());
        ticket.setCinema(updatedTicket.getCinema());
        ticketRepository.save(ticket);
    }


}
