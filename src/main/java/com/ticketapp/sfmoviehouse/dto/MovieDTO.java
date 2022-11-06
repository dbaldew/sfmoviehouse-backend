package com.ticketapp.sfmoviehouse.dto;

import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import java.util.List;

public class MovieDTO {

    public Long movieID;
    public String title;
    public String year;
    public String category;
    public String summary;
    public String description;
    private List<Ticket> tickets;

    public static MovieDTO fromMovie(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.movieID = movie.getMovieID();
        movieDTO.title = movie.getTitle();
        movieDTO.year = movie.getYear();
        movieDTO.category = movie.getCategory();
        movieDTO.summary = movie.getSummary();
        movieDTO.description = movie.getDescription();
        movieDTO.tickets = movie.getTickets();
        return movieDTO;
    }

    public Movie toMovie() {
        var movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setCategory(category);
        movie.setSummary(summary);
        movie.setDescription(description);
        movie.setTickets(tickets);
        return movie;
    }
}
