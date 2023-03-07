package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import com.ticketapp.sfmoviehouse.repository.TicketRepository;
import org.assertj.core.api.Assertions;
import org.h2.engine.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Mock
    private Movie movie;

    @Mock
    private MovieDTO movieDTO;

    @Mock
    Database databaseMock;




    @BeforeEach
    void setUp(){
        movie = new Movie();
        movie.setMovieID(1L);
        movie.setCategory("horror");
        movie.setDescription("descr");
        movie.setYear("1979");
        movie.setSummary("sum");
        movie.setTitle("Jaws");
    }


    @Test
    void shouldReturnAllMoviesDTO() {
        Movie movie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        MovieDTO movieDTO = MovieDTO.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        Mockito
                .when(movieRepository.findAll())
                .thenReturn(movies);

        var actual = movieService.findAllMovies();
       Assertions.assertThat(actual.size()).isEqualTo(movies.size());
    }

    @Test
    void findAllMoviesByTitle() {
    }

    @Test
    void findAllMoviesByYear() {
    }

    @Test
    void findAllMoviesByCategory() {
    }

    @Test
    void findMovieById() {
    }

    @Test
    void shouldSaveAMovieToDatabase() {
        Movie movie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        MovieDTO movieDTO = MovieDTO.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        when(movieRepository.save(Mockito.any(Movie.class)))
                .thenReturn(movie);

        MovieDTO savedMovie = movieService.save(movieDTO);
        Assertions.assertThat(savedMovie).isNotNull();
    }

    @Test
    void updateMovie() {
    }

    @Test
    void deleteById() {
    }
}