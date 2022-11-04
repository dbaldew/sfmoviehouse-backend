package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import com.ticketapp.sfmoviehouse.repository.TicketRepository;
import com.ticketapp.sfmoviehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Ticket> findAll() {
        Iterable<Ticket> ticketList = ticketRepository.findAll();
        return ticketList;
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

    public void updateTicket(Long id, Ticket updatedTicket) {
        if (!ticketRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setDate(updatedTicket.getDate());
        ticket.setCinema(updatedTicket.getCinema());
        ticketRepository.save(ticket);
    }


}
