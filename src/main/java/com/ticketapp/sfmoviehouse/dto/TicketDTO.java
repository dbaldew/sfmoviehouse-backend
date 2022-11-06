package com.ticketapp.sfmoviehouse.dto;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import com.ticketapp.sfmoviehouse.entity.User;

public class TicketDTO {
    public long ticketID;
    public String date;
    public String time;
    public String cinema;
    public Movie movie;
    public User user;

    public TicketDTO() {
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
