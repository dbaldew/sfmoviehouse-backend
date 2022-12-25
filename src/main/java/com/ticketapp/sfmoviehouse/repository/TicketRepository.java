package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;

import com.ticketapp.sfmoviehouse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    List<Ticket> findTicketsByUser(User username);
    List <Ticket> findTicketsByMovie(Movie movieID);
}
