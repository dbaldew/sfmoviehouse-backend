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
    //ticketID

    public Customer() {
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
}
