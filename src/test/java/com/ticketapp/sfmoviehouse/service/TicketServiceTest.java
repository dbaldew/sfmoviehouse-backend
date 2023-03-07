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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @InjectMocks
    private TicketService ticketService;
    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    private Ticket ticket;

    @InjectMocks
    Movie movie;

    @InjectMocks
    User user;

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
    void shouldReturnAllTicketsByUser() {

        List<Ticket> tickets = new ArrayList<>();

        User testUser = User.builder()
                .username("Tester")
                .password("123")
                .enabled(true)
                .build();

        Movie testMovie = Movie.builder()
                .movieID(1L)
                .title("TestMovie")
                .year("2023")
                .category("TestCategory")
                .summary("TestSummary")
                .description("TestDescription")
                .build();

        Ticket testTicket = Ticket.builder()
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .user(testUser)
                .movie(testMovie)
                .build();

        tickets.add(testTicket);

        when(ticketRepository.findTicketsByUser("Tester"))
                .thenReturn(tickets);

        var actual = ticketService.findAllTicketsByUser("Tester");
        Assertions.assertThat(actual.size()).isEqualTo(tickets.size());

    }

    @Test
    void shouldReturnAllTicketsByMovieID() {

        List<Ticket> tickets = new ArrayList<>();

        User testUser = User.builder()
                .username("Tester")
                .password("123")
                .enabled(true)
                .build();

        Movie testMovie = Movie.builder()
                .movieID(1L)
                .title("TestMovie")
                .year("2023")
                .category("TestCategory")
                .summary("TestSummary")
                .description("TestDescription")
                .build();

        Ticket testTicket = Ticket.builder()
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .user(testUser)
                .movie(testMovie)
                .build();

        tickets.add(testTicket);
        when(movieRepository.getById(1L))
                .thenReturn(testMovie);
        when(ticketRepository.findTicketsByMovie(testMovie))
                .thenReturn(tickets);

        var actual = ticketService.findAllTicketsByMovieID(1L);

        Assertions.assertThat(actual.size()).isEqualTo(tickets.size());
    }

    @Test
    void shouldFindTicketById() {

        User testUser = User.builder()
                .username("Tester")
                .password("123")
                .enabled(true)
                .build();

        Movie testMovie = Movie.builder()
                .movieID(1L)
                .title("TestMovie")
                .year("2023")
                .category("TestCategory")
                .summary("TestSummary")
                .description("TestDescription")
                .build();

        Ticket testTicket = Ticket.builder()
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .user(testUser)
                .movie(testMovie)
                .build();

        when(ticketRepository.findById(1L))
                .thenReturn(Optional.ofNullable(testTicket));

        var actual = ticketService.findById(1L);
        Assertions.assertThat(actual.ticketID).isEqualTo(1L);

    }

    @Test
    void shouldSaveTicketToDatabase() {

        User testUser = User.builder()
                .username("Tester")
                .password("123")
                .enabled(true)
                .build();

        Movie testMovie = Movie.builder()
                .movieID(1L)
                .title("TestMovie")
                .year("2023")
                .category("TestCategory")
                .summary("TestSummary")
                .description("TestDescription")
                .build();

        Ticket testTicket = Ticket.builder()
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .user(testUser)
                .movie(testMovie)
                .build();

        TicketDTO testTicketDTO = TicketDTO.builder()
                .ticketID(1L)
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .movieID(1L)
                .username("Tester")
                .build();

        when(ticketRepository.save(Mockito.any(Ticket.class)))
                .thenReturn(testTicket);

        TicketDTO savedTicket = ticketService.save(testTicketDTO);
        Assertions.assertThat(savedTicket).isNotNull();
    }

    @Test
    void updateTicket() {
        User testUser = User.builder()
                .username("Tester")
                .password("123")
                .enabled(true)
                .build();

        Movie testMovie = Movie.builder()
                .movieID(1L)
                .title("TestMovie")
                .year("2023")
                .category("TestCategory")
                .summary("TestSummary")
                .description("TestDescription")
                .build();

        Ticket testTicket = Ticket.builder()
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .user(testUser)
                .movie(testMovie)
                .build();

        TicketDTO testTicketDTO = TicketDTO.builder()
                .ticketID(1L)
                .ticketID(1L)
                .date("01-01-2023")
                .time("20:00")
                .cinema("1")
                .movieID(1L)
                .username("Tester")
                .build();


        when(ticketRepository.save(Mockito.any(Ticket.class)))
                .thenReturn(testTicket);

        TicketDTO upDatedTicket = ticketService.save(testTicketDTO);
        Assertions.assertThat(upDatedTicket).isNotNull();

    }

    @Test
    void deleteById() {
        ticketRepository.deleteById(1L);
        Mockito.verify(ticketRepository).deleteById(1L);
    }
}