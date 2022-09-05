package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository <Event, Long> {
}
