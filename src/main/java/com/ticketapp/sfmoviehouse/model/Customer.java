package com.ticketapp.sfmoviehouse.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String name;
    //password;
    //role

    //one to many preferences;
    //one to many favorites;
    //avatar;
    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Customer() {
    }
    public Customer(String name, List<Ticket> tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id, Customer customer) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}