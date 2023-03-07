package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.TicketDTO;
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
import java.util.stream.Collectors;

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

    public List<TicketDTO> findAllTickets() {
        List<Ticket> ticketList = ticketRepository.findAll();
        List<TicketDTO> ticketDTOList = ticketList.stream().map(TicketDTO::fromTicket)
                .collect(Collectors.toList());
        return ticketDTOList;
    }

    public List<TicketDTO> findAllTicketsByUser (String username){
        User user = userRepository.getById(username);
        List<Ticket> userTicketList = ticketRepository.findTicketsByUser(username);
        List<TicketDTO> userTicketDTOList = userTicketList.stream().map(TicketDTO::fromTicket)
                .collect(Collectors.toList());
        return userTicketDTOList;
    }

    public List<TicketDTO> findAllTicketsByMovieID (long movieID){
        Movie movie = movieRepository.getById(movieID);
        List<Ticket> idTicketList = ticketRepository.findTicketsByMovie(movie);
                List<TicketDTO> idTicketDTOList = idTicketList.stream().map(TicketDTO::fromTicket)
                .collect(Collectors.toList());
        return idTicketDTOList;
    }

    public TicketDTO findById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            return TicketDTO.fromTicket(ticketOptional.get());
        }else {
            throw new RecordNotFoundException();
        }
    }

    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket t = ticketDTO.toTicket();
        ticketRepository.save(t);
        return TicketDTO.fromTicket(t);
    }

    public TicketDTO updateTicket(Long id, TicketDTO toUpdateTicketDTO) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            Ticket t = ticketOptional.get();
            t.setDate(toUpdateTicketDTO.getDate());
            t.setTime(toUpdateTicketDTO.getTime());
            t.setCinema(toUpdateTicketDTO.getCinema());
            t.setMovie(toUpdateTicketDTO.toTicket().getMovie());
            t.setUser(toUpdateTicketDTO.toTicket().getUser());
            ticketRepository.save(t);
            return TicketDTO.fromTicket(t);
        }else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            ticketRepository.deleteById(id);
        }else {
            throw new RecordNotFoundException();
        }
    }
}
