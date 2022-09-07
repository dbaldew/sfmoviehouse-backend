package com.ticketapp.sfmoviehouse.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    private String date;
    private String cinema;

    //movieID;
    //availableTickets;

    public Event() {
    }

    public Event(Long eventID, String date, String cinema) {
        this.eventID = eventID;
        this.date = date;
        this.cinema = cinema;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }
}
