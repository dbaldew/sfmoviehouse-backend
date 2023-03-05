package com.ticketapp.sfmoviehouse.dto;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.entity.User;

public class TicketDTO {
    public long ticketID;
    public String date;
    public String time;
    public String cinema;
    public Long movieID;

    public String username;

    public TicketDTO() {
    }

    public long getTicketID() {
        return ticketID;
    }

    public void setTicketID(long ticketID) {
        this.ticketID = ticketID;
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

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static TicketDTO fromTicket(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.ticketID = ticket.getTicketID();
        ticketDTO.date = ticket.getDate();
        ticketDTO.time = ticket.getTime();
        ticketDTO.cinema = ticket.getCinema();
        ticketDTO.movieID = ticket.getMovie().getMovieID();
        ticketDTO.username = ticket.getUser().getUsername();
        return ticketDTO;
    };
    public Ticket toTicket(){
        Ticket ticket = new Ticket();
        ticket.setDate(date);
        ticket.setTime(time);
        ticket.setCinema(cinema);
        ticket.setMovie(new Movie());
        ticket.getMovie().setMovieID(movieID);
        ticket.setUser(new User());
        ticket.getUser().setUsername(username);
        return ticket;
    }
}
