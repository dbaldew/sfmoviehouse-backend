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
