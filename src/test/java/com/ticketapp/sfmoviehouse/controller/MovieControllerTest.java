package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.service.MovieService;
import com.ticketapp.sfmoviehouse.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(MovieController.class)
class MovieControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;
//    @MockBean
//    private MovieRepository movieRepository;
    @MockBean
    private DataSource dataSource;
    @MockBean
    private JwtUtil jwtUtil;
//    @MockBean
//    private JwtRequestFilter jwtRequestFilter;

    @Mock
    Movie movie1;
    @Mock
    Movie movie2;
    @Mock
    MovieDTO movieDTO1;
    @Mock
    MovieDTO movieDTO2;
    @Mock
    MovieDTO toUpdateMovieDTO1;
    @Mock
    MovieDTO toUpdateMovieDTO2;


    @BeforeEach
    public void setUp() {

         movie1 = new Movie(
                1L,
                "Jaws",
                "1979",
                "horror",
                "Jaws",
                "holiday When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down."
        );

         movie2 = new Movie(
                2L,
                "Mars Attacks",
                "1996",
                "sf comedy",
                "Mars attacks summary",
                "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor."
        );

         movieDTO1 = new MovieDTO(
                1L,
                "Jaws",
                "1979",
                "horror",
                "Jaws",
                "holiday When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down."
        );

         movieDTO2 = new MovieDTO(
                2L,
                "Mars Attacks",
                "1996",
                "sf comedy",
                "Mars attacks summary",
                "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor."
        );

         toUpdateMovieDTO1 = new MovieDTO(
                1L,
                "Jaws",
                "1979",
                "horror",
                "Jaws",
                "holiday When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down."
        );

         toUpdateMovieDTO2 = new MovieDTO(
                 2L,
                 "Mars Attacks",
                 "1996",
                 "sf comedy",
                 "Mars attacks summary",
                 "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor."
         );
    }

    @Test
    void shouldGetAllMovies() throws Exception {

        List<MovieDTO> movieDTOList = new ArrayList<>();
        movieDTOList.add(movieDTO1);
        movieDTOList.add(movieDTO2);

        given(movieService.findAllMovies()).willReturn(movieDTOList);

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].movieID").value(1L))
                .andExpect(jsonPath("$[1].movieID").value(2L));
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