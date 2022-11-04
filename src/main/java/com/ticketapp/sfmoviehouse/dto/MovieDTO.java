package com.ticketapp.sfmoviehouse.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.ticketapp.sfmoviehouse.entity.Movie;

public class MovieDTO {
    private Long movieID;
    @JsonIncludeProperties("id")
    private String title;
    private String year;
    private String category;
    private String header;
    private String description;

    public MovieDTO() {
    }

    public MovieDTO(Long movieID, String title, String year, String category, String header, String description) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.category = category;
        this.header = header;
        this.description = description;
    }

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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static MovieDTO fromMovie (Movie movie){
        MovieDTO dto = new MovieDTO();
        dto.movieID = movie.getMovieID();
        dto.title = movie.getTitle();
        dto.year = movie.getYear();
        dto.category = movie.getCategory();
        dto.header = movie.getHeader();
        dto.description = movie.getDescription();
        return dto;
    }
    public Movie toMovie (){
        var movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setCategory(category);
        movie.setHeader(header);
        movie.setDescription(description);
        return movie;
    }
}
