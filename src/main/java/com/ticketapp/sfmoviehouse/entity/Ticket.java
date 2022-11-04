package com.ticketapp.sfmoviehouse.entity;

import javax.persistence.*;

@Entity
@Table (name = "tickets")
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String time;
    private String cinema;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "movieID")
    private Movie movie;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;


    public Ticket(){}
    public Ticket(long id, String date, String time, String cinema, Movie movie, User user) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.cinema = cinema;
        this.movie = movie;
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }
}
