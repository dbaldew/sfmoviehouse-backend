package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.*;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private Movie movie;
    @InjectMocks
    private MovieService movieService;
    @Captor
    ArgumentCaptor<Movie> movieArgumentCaptor;

    @BeforeEach
    void setUp() {
        movie = new Movie();
        movie.setMovieID(1L);
        movie.setCategory("horror");
        movie.setDescription("descr");
        movie.setYear("1979");
        movie.setSummary("sum");
        movie.setTitle("Jaws");
    }
    @Test
    void shouldReturnAllMovies() {

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAll())
                .thenReturn(movies);

        var actual = movieService.findAllMovies();
        verify(movieRepository, times(1)).findAll();

        Assertions.assertThat(actual.size()).isEqualTo(movies.size());
        Assertions.assertThat(actual.get(0).getMovieID()).isEqualTo(1L);

    }
    @Test
    void shouldReturnAllMoviesByTitle() {

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAllByTitle("Jaws"))
                .thenReturn(movies);

        var actual = movieService.findAllMoviesByTitle("Jaws");
        verify(movieRepository, times(1)).findAllByTitle("Jaws");

        Assertions.assertThat(actual.get(0).getTitle()).isEqualTo("Jaws");
    }
    @Test
    void shouldReturnAllMoviesByYear() {

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAllByYear("1979"))
                .thenReturn(movies);

        var actual = movieService.findAllMoviesByYear("1979");
        verify(movieRepository, times(1)).findAllByYear("1979");

        Assertions.assertThat(actual.get(0).getYear()).isEqualTo("1979");
    }
    @Test
    void shouldReturnAllMoviesByCategory() {

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAllByCategory("horror"))
                .thenReturn(movies);

        var actual = movieService.findAllMoviesByCategory("horror");
        verify(movieRepository, times(1)).findAllByCategory("horror");

        Assertions.assertThat(actual.get(0).getCategory()).isEqualTo("horror");
    }
    @Test
    void shouldReturnMovieById() {

        when(movieRepository.findById(1L))
                .thenReturn(Optional.of(movie));

        var actual = movieService.findMovieById(1L);
        verify(movieRepository, times(1)).findById(1L);

        Assertions.assertThat(actual.movieID).isEqualTo(movie.getMovieID());

    }
    @Test
    void shouldSaveMovieToDatabase() {

        movieRepository.save(movie);

        verify(movieRepository, times(1)).save(movieArgumentCaptor.capture());
        var actual = movieArgumentCaptor.getValue();

        Assertions.assertThat(actual.getMovieID()).isEqualTo(movie.getMovieID());
        Assertions.assertThat(actual.getTitle()).isEqualTo(movie.getTitle());
    }
    @Test
    void shouldUpdateMovie() {

        Movie movieUpdate = new Movie();
        movieUpdate.setCategory("sf comedy");
        movieUpdate.setDescription("sf comedy");
        movieUpdate.setYear("1996");
        movieUpdate.setSummary("Mars Attacks");
        movieUpdate.setTitle("mars attacks");

        when(movieRepository.findById(anyLong()))
                .thenReturn(Optional.of(movie));

        var actual = movieService.updateMovie(1L, MovieDTO.fromMovie(movieUpdate));
        Assertions.assertThat(actual.getCategory()).isEqualTo(movie.getCategory());
        Assertions.assertThat((actual.getTitle())).isEqualTo(movie.getTitle());
    }

    @Test
    void shouldDeleteMovieByID() {

        movieRepository.deleteById(1L);
        Mockito.verify(movieRepository).deleteById(1L);
    }
}