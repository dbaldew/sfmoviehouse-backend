package com.ticketapp.sfmoviehouse.model;

import javax.persistence.*;



@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String date;
    private String time;
    private String cinema;

    //eventID;
    //movieID;
    //customerID

    public Ticket() {

    }

    public Ticket(long id, String date, String time, String cinema) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.cinema = cinema;
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
