package com.ticketapp.sfmoviehouse.dto;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.entity.User;

public class TicketDTO {

    private long ticketID;
    private String date;
    private String time;
    private String cinema;
    private Movie movie;
    private User user;

    public TicketDTO() {
    }

    public TicketDTO(long id, String date, String time, String cinema, Movie movie, User user) {
        this.ticketID = id;
        this.date = date;
        this.time = time;
        this.cinema = cinema;
        this.movie = movie;
        this.user = user;
    }

    public long getId() {
        return ticketID;
    }

    public void setId(long id) {
        this.ticketID = id;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static TicketDTO fromTicket(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.ticketID = ticket.getTicketID();
        ticketDTO.date = ticket.getDate();
        ticketDTO.time = ticket.getTime();
        ticketDTO.cinema = ticket.getCinema();
        ticketDTO.movie = ticket.getMovie();
        ticketDTO.user = ticket.getUser();
        return ticketDTO;
    };
    public Ticket toTicket(){
        var ticket = new Ticket();
        ticket.setDate(date);
        ticket.setTime(time);
        ticket.setCinema(cinema);
        ticket.setMovie(movie);
        ticket.setUser(user);
        return ticket;
    }
}
