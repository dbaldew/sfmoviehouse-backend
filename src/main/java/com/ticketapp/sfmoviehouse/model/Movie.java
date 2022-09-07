package com.ticketapp.sfmoviehouse.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieID;

    private String title;
    private String year;
    private String category;

    //one to many Event


    public Movie() {

    }

    public Movie(Long movieID, String title, String year, String category) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.category = category;
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
}

