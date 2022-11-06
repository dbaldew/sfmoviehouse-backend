package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    public Movie findById(long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            return movieOptional.get();
        }
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            movieRepository.deleteById(id);
        }
    }

    public void updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new RecordNotFoundException();
        } else  {
            Movie movie = movieRepository.findById(id).orElseThrow();
            movie.setTitle(updatedMovie.getTitle());
            movie.setYear(updatedMovie.getYear());
            movie.setCategory(updatedMovie.getCategory());
            movie.setSummary(updatedMovie.getSummary());
            movie.setDescription(updatedMovie.getDescription());
            movie.setTickets(updatedMovie.getTickets());
            movieRepository.save(movie);
        }
    }
}