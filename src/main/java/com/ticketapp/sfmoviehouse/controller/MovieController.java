package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
        var movies = movieService.findAllMovies()
                .stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "title/{title}")
    public ResponseEntity <List<MovieDTO>> getAllMoviesByTitle(@PathVariable String title) {
        var movies = movieService.findAllMoviesByTitle(title)
                .stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping(value = "year/{year}")
    public ResponseEntity <List<MovieDTO>> getAllMoviesByYear(@PathVariable String year) {
        var movies = movieService.findAllMoviesByYear(year)
                .stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping(value = "category/{category}")
    public ResponseEntity <List<MovieDTO>> getAllMoviesByCategory(@PathVariable String category) {
        var movies = movieService.findAllMoviesByCategory(category)
                .stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "id/{id}")
    public ResponseEntity<MovieDTO>getMovieById(@PathVariable Long id){
        var movie = MovieDTO.fromMovie(movieService.findMovieById(id));
        return ResponseEntity.ok().body(movie);
    }
    @PostMapping(value = "")
    public ResponseEntity<Object>addMovie(@RequestBody MovieDTO movieDTO) {
        Movie newMovie = movieService.save(movieDTO.toMovie());
        Long id = newMovie.getMovieID();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity <Object> deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok("removed movie ");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        var updatedMovie = movieDTO.toMovie();
        movieService.updateMovie(id, updatedMovie);
        return ResponseEntity.noContent().build();
    }

}
