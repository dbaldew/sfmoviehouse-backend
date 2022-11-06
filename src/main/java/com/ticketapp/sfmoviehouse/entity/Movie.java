package com.ticketapp.sfmoviehouse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieID;
    private String title;
    private String year;
    private String category;
    private String summary;
    private String description;

    //////////////////////////////////////////
    @OneToMany(mappedBy = "movie")
    private List<Ticket> tickets = new ArrayList<>();

    //////////////////////////////////////////

    public Movie() {
    }

    public Movie(Long movieID, String title, String year, String category, String summary, String description, List<Ticket> tickets) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.category = category;
        this.summary = summary;
        this.description = description;
        this.tickets = tickets;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

