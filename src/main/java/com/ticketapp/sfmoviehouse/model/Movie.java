package com.ticketapp.sfmoviehouse.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieID;
    private String title;
    private String year;
    private String category;
    @OneToMany(
            targetEntity = Ticket.class,
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    public Movie(){}
    public Movie(Long movieID, String title, String year, String category, Set<Ticket> tickets) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.category = category;
        this.tickets= tickets;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}

