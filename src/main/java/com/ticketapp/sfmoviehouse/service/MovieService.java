package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.model.Movie;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> findAll() {
        Iterable<Movie> movies = movieRepository.findAll();
        return movies;
    }

    public Optional<Movie> findById(long id) {
        if (!movieRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return movieRepository.findById(id);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        movieRepository.deleteById(id);
    }

    public void updateMovie(Long id, Movie updatedMovie) {
        if(!movieRepository.existsById(id)){
            throw new RecordNotFoundException();
        }
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(updatedMovie.getTitle());
        movie.setYear(updatedMovie.getYear());
        movie.setCategory(updatedMovie.getCategory());
        movieRepository.save(movie);
    }
}