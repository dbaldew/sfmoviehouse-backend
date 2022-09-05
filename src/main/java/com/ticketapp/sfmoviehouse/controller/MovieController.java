package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Movie;
import com.ticketapp.sfmoviehouse.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public ResponseEntity getMovie() {
        Iterable<Movie> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

}
