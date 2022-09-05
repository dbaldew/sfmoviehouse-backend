package com.ticketapp.sfmoviehouse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String name;
    //password;
    //role

    //one to many preferences;
    //one to many favorites;
    //one to many tickets;
    //avatar;



}