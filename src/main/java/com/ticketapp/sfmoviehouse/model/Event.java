package com.ticketapp.sfmoviehouse.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;
    private String date;
    private String cinema;
    private Long availableTickets;

    //movieID;

    public Event(){}
    public Event(Long eventID, String date, String cinema, Long availableTickets) {
        this.eventID = eventID;
        this.date = date;
        this.cinema = cinema;
        this.availableTickets = availableTickets;
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

    public long getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Long availableTickets) {
        this.availableTickets = availableTickets;
    }
}
