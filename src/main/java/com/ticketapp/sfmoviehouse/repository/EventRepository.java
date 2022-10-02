package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
