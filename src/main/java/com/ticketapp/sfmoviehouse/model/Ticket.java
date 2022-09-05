package com.ticketapp.sfmoviehouse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketID;
	private Date date;
    private String cinema;

    //userID;
    //eventID;
    //movieID;

}
