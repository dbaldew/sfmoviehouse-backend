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

    public List<Ticket> findAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets;
    }

    public Ticket findTicketById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }else {
            return ticketOptional.get();
        }
    }

    public Ticket save(Ticket ticket) {
        

        return ticketRepository.save(ticket);

    }

    public void deleteById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }else {
            ticketRepository.deleteById(id);
        }
    }

    public void updateTicket(Long id, Ticket updatedTicket) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }else {
            Ticket ticket = ticketRepository.findById(id).orElseThrow();
            ticket.setDate(updatedTicket.getDate());
            ticket.setTime(updatedTicket.getTime());
            ticket.setCinema(updatedTicket.getCinema());
            ticket.setMovie(updatedTicket.getMovie());
            ticket.setUser(updatedTicket.getUser());
            ticketRepository.save(ticket);
        }
    }
}
