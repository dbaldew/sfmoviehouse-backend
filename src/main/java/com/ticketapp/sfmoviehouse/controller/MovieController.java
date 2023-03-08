package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value = "/movies")
public class MovieController {

    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping(value = "")
    public ResponseEntity <List<MovieDTO>> getAllMovies() {
        var movies = movieService.findAllMovies();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "/{title}")
    public ResponseEntity <List<MovieDTO>> getAllMoviesByTitle(@PathVariable String title) {
        var movies = movieService.findAllMoviesByTitle(title);
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping(value = "/{year}")
    public ResponseEntity <List<MovieDTO>> getAllMoviesByYear(@PathVariable String year) {
        var movies = movieService.findAllMoviesByYear(year);
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping(value = "/{category}")
    public ResponseEntity <List<MovieDTO>> getAllMoviesByCategory(@PathVariable String category) {
        var movies = movieService.findAllMoviesByCategory(category);
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO>getMovieById(@PathVariable Long id){
        var movie = movieService.findMovieById(id);
        return ResponseEntity.ok().body(movie);
    }
    @PostMapping(value = "")
    public ResponseEntity<MovieDTO>addMovie(@RequestBody MovieDTO movieDTO) {
        var movie  = movieService.save(movieDTO);
        Long id = movie.getMovieID();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDTO toUpdateMovieDTO){
        MovieDTO movieDTO = movieService.updateMovie(id, toUpdateMovieDTO);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity <Object> deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok("removed movie ");
    }
}
