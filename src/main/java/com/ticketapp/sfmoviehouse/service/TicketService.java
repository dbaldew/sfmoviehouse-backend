package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.User;
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
        List<Ticket> ticketList = ticketRepository.findAll();
        return ticketList;
    }

    public List<Ticket> findAllTicketsByUser (String username){
        User user = userRepository.getById(username);
        return ticketRepository.findTicketsByUser(user);
    }

    public List<Ticket> findAllTicketsByMovieID (long movieID){
        Movie movie = movieRepository.getById(movieID);
        return ticketRepository.findTicketsByMovie(movie);
    }

    public Ticket findById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }else {
            return ticketOptional.get();
        }
    }



    public Ticket save(Ticket ticket) {
        Ticket newTicket = new Ticket();
        newTicket.setDate(ticket.getDate());
        newTicket.setTime(ticket.getTime());
        newTicket.setCinema(ticket.getCinema());

        Optional<Movie> movieOptional = movieRepository.findById(ticket.getMovie().getMovieID());
        if(movieOptional.isPresent()){
            newTicket.setMovie(movieOptional.get());
        }else throw new RecordNotFoundException();

        Optional<User> userOptional = userRepository.findById(ticket.getUser().getUsername());
        if(userOptional.isPresent()){
            newTicket.setUser(ticket.getUser());

        }else throw new RecordNotFoundException();

        return ticketRepository.save(newTicket);
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
            Ticket ticket = ticketRepository.findById(id).get();
            ticket.setDate(updatedTicket.getDate());
            ticket.setTime(updatedTicket.getTime());
            ticket.setCinema(updatedTicket.getCinema());
            ticket.setMovie(updatedTicket.getMovie());
            ticket.setUser(updatedTicket.getUser());
            ticketRepository.save(ticket);
        }
    }
}
