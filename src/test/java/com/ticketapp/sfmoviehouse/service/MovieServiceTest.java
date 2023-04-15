package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;
    @Mock
    private MovieRepository movieRepository;
    private Movie movie;


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
        Movie movie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAll())
                .thenReturn(movies);

        var actual = movieService.findAllMovies();
        Assertions.assertThat(actual.size()).isEqualTo(movies.size());
    }

    @Test
    void shouldReturnAllMoviesByTitle() {
        Movie movie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();


        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAllByTitle("title"))
                .thenReturn(movies);

        var actual = movieService.findAllMoviesByTitle("title");
        Assertions.assertThat(actual.size()).isEqualTo(movies.size());
    }

    @Test
    void shouldReturnAllMoviesByYear() {
        Movie movie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();


        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAllByYear("year"))
                .thenReturn(movies);

        var actual = movieService.findAllMoviesByYear("year");
        Assertions.assertThat(actual.size()).isEqualTo(movies.size());
    }

    @Test
    void shouldReturnAllMoviesByCategory() {
        Movie movie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        when(movieRepository.findAllByCategory("category"))
                .thenReturn(movies);

        var actual = movieService.findAllMoviesByCategory("category");
        Assertions.assertThat(actual.size()).isEqualTo(movies.size());
    }

    @Test
    void shouldReturnMovieById() {
        Movie testMovie = Movie.builder()
                .movieID(1L)
                .description("descr")
                .title("title")
                .summary("summary")
                .year("year")
                .category("category")
                .build();

        when(movieRepository.findById(1L))
                .thenReturn(Optional.ofNullable(movie));

        var actual = movieService.findMovieById(1L);

        Assertions.assertThat(actual.movieID).isEqualTo(movie.getMovieID());

    }

    @Test
    void shouldSaveMovieToDatabase() {
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
    void shouldUpdateMovie() {
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

        when(movieRepository.findById(1L))
                .thenReturn(Optional.ofNullable(movie));
        when(movieRepository.save(Mockito.any(Movie.class)))
                .thenReturn(movie);

        MovieDTO savedMovie = movieService.updateMovie(1L,movieDTO);
        Assertions.assertThat(savedMovie).isNotNull();
    }

    @Test
    void shouldDeleteMovieByID() {

        movieRepository.deleteById(1L);
        Mockito.verify(movieRepository).deleteById(1L);
    }
}