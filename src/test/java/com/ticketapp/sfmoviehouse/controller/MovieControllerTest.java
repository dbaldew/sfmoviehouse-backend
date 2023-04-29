package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @MockBean
    private MovieService movieService;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp(){

        Movie movie1 = new Movie(
                1L,
                "Jaws",
                "1979",
                "horror",
                "Jaws",
                "holiday When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down."
        );

        Movie movie2 = new Movie(
                2L,
                "Mars Attacks",
                "1996",
                "sf comedy",
                "Mars attacks summary",
                "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor."
        );


        MovieDTO movieDTO1 = new MovieDTO(
                1L,
                "Jaws",
                "1979",
                "horror",
                "Jaws",
                "holiday When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down."
        );

        MovieDTO movieDTO2 = new MovieDTO(
                2L,
                "Mars Attacks",
                "1996",
                "sf comedy",
                "Mars attacks summary",
                "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor."
        );

        MovieDTO toUpdateMovieDTO1 = new MovieDTO(
                1L,
                "Jaws",
                "1979",
                "horror",
                "Jaws",
                "holiday When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down."
        );

        MovieDTO toUpdateMovieDTO2 = new MovieDTO(
                2L,
                "Mars Attacks",
                "1996",
                "sf comedy",
                "Mars attacks summary",
                "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor."
        );
    }

    @Test
    void getAllMovies() {



    }

    @Test
    void getAllMoviesByTitle() {
    }

    @Test
    void getAllMoviesByYear() {
    }

    @Test
    void getAllMoviesByCategory() {
    }

    @Test
    void getMovieById() {
    }

    @Test
    void addMovie() {
    }

    @Test
    void updateMovie() {
    }

    @Test
    void deleteMovie() {
    }
}