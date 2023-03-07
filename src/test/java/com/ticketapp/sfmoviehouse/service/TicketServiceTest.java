package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.TicketDTO;
import com.ticketapp.sfmoviehouse.entity.Authority;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.entity.User;
import com.ticketapp.sfmoviehouse.repository.TicketRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @Mock
    private Ticket ticket;

    @Mock
    Movie movie;

    @Mock
    User user;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setTicketID(1L);
        ticket.setDate("01-01-2023");
        ticket.setTime("20:00");
        ticket.setCinema("1");
        movie = new Movie();
        movie.setMovieID(1L);
        movie.setCategory("horror");
        movie.setDescription("descr");
        movie.setYear("1979");
        movie.setSummary("sum");
        movie.setTitle("Jaws");
        user = new User();
        user.setUsername("testUser");
        user.setPassword("123");
        user.setEnabled(true);
        Set<Authority> authorities = new HashSet<>();
    }

    @Test
    void shouldReturnAllTickets() {
        Ticket ticket = Ticket.builder()
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .movie(movie)
                .user(user)
                .build();

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        when(ticketRepository.findAll())
                .thenReturn(tickets);

        var actual = ticketService.findAllTickets();
        Assertions.assertThat(actual.size()).isEqualTo(tickets.size());

    }

    @Test
    void findAllTicketsByUser() {
    }

    @Test
    void findAllTicketsByMovieID() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void updateTicket() {
    }

    @Test
    void deleteById() {
    }
}