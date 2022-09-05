package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.model.Movie;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import org.springframework.stereotype.Service;

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
}