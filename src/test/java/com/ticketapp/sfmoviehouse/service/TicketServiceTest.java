package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.TicketDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.entity.User;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import com.ticketapp.sfmoviehouse.repository.TicketRepository;

import com.ticketapp.sfmoviehouse.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    Ticket ticket;
    @Mock
    TicketDTO ticketDTO;
    @Mock
    Movie movie;
    @Mock
    User user;
    @InjectMocks
    private TicketService ticketService;
    @Captor
    ArgumentCaptor<Ticket> ticketCaptor;
    @BeforeEach
    void setUp(){
        ticket = new Ticket();
        movie = new Movie();
        user = new User();
        ticket.setTicketID(1L);
        ticket.setDate("01-01-2023");
        ticket.setTime("20:00");
        ticket.setCinema("1");
        ticket.setMovie(movie);
        ticket.setUser(user);
        movie.setMovieID(1L);
        movie.setTitle("TestMovie");
        movie.setYear("2023");
        movie.setCategory("TestCategory");
        movie.setSummary("TestSummary");
        movie.setDescription("TestDescription");
        user.setUsername("Tester");
        user.setPassword("123");
        user.setEnabled(true);
    }
    @Test
    void shouldReturnAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        when(ticketRepository.findAll())
                .thenReturn(tickets);

        var actual = ticketService.findAllTickets();

        verify(ticketRepository, times(1)).findAll();

        Assertions.assertThat(actual.size()).isEqualTo(tickets.size());
        Assertions.assertThat(actual.get(0).getTicketID()).isEqualTo(1L);

    }
    @Test
    void shouldReturnAllTicketsByUser() {

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        when(ticketRepository.findTicketsByUser("Tester"))
                .thenReturn(tickets);

        var actual = ticketService.findAllTicketsByUser("Tester");
        verify(ticketRepository, times(1)).findTicketsByUser("Tester");

        Assertions.assertThat(actual.get(0).getTicketID()).isEqualTo(1L);

    }

    @Test
    void shouldReturnAllTicketsByMovieID() {

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        when(movieRepository.getById(1L))
                .thenReturn(movie);
        when(ticketRepository.findTicketsByMovie(movie))
                .thenReturn(tickets);

        var actual = ticketService.findAllTicketsByMovieID(1L);
        verify(ticketRepository, times(1)).findTicketsByMovie(movie);

        Assertions.assertThat(actual.get(0).getTicketID()).isEqualTo(1L);

    }

    @Test
    void shouldFindTicketById() {

        when(ticketRepository.findById(1L))
                .thenReturn(Optional.of(ticket));

        var actual = ticketService.findById(1L);
        verify(ticketRepository, times(1)).findById(1L);

        Assertions.assertThat(actual.ticketID).isEqualTo(1L);

    }
    @Test
    void shouldSaveTicketToDatabase() {

        ticketRepository.save(ticket);

        verify(ticketRepository, times(1)).save(ticketCaptor.capture());
        var actual = ticketCaptor.getValue();

        Assertions.assertThat(actual.getTicketID()).isEqualTo(ticket.getTicketID());

    }

    @Test
    void updateTicket() {

        Ticket ticketUpdate = new Ticket();
        ticketUpdate.setTicketID(1L);
        ticketUpdate.setDate("01-02-2023");
        ticketUpdate.setTime("21:00");
        ticketUpdate.setCinema("2");
        ticketUpdate.setMovie(movie);
        ticketUpdate.setUser(user);

        when(ticketRepository.findById(anyLong())).thenReturn(Optional.of(ticketUpdate));

        var actual = ticketService.updateTicket(1L, TicketDTO.fromTicket(ticket));
        Assertions.assertThat(actual.getTicketID()).isEqualTo(ticket.getTicketID());
        Assertions.assertThat(actual.getDate()).isEqualTo(ticket.getDate());

    }

    @Test
    void deleteById() {
        ticketRepository.deleteById(1L);
        Mockito.verify(ticketRepository).deleteById(1L);
    }
}