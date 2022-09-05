package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository <Ticket, Long> {
}
