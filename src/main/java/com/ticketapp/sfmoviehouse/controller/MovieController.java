package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Movie;
import com.ticketapp.sfmoviehouse.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/movies")
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping(value = "")
    public ResponseEntity <Object>getMovie() {
        return ResponseEntity.ok().body(movieService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object>getMovieById(@PathVariable Long id){
        return ResponseEntity.ok().body(movieService.findById(id));
    }
    @PostMapping(value = "")
    public ResponseEntity<Object>addMovie(@RequestBody Movie movie) {
        movieService.save(movie);
        return ResponseEntity.ok("added movie");
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Object> deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok("removed movie");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok("updated movie");
    }

}
