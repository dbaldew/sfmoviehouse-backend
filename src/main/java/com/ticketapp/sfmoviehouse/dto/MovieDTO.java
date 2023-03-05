package com.ticketapp.sfmoviehouse.dto;

import com.ticketapp.sfmoviehouse.entity.Movie;

public class MovieDTO {

    public Long movieID;
    public String title;
    public String year;
    public String category;
    public String summary;
    public String description;

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static MovieDTO fromMovie(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.movieID = movie.getMovieID();
        movieDTO.title = movie.getTitle();
        movieDTO.year = movie.getYear();
        movieDTO.category = movie.getCategory();
        movieDTO.summary = movie.getSummary();
        movieDTO.description = movie.getDescription();
        return movieDTO;
    }

    public  Movie toMovie() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setCategory(category);
        movie.setSummary(summary);
        movie.setDescription(description);
        return movie;
    }
}
