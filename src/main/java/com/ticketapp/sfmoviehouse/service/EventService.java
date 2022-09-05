package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.model.Event;
import com.ticketapp.sfmoviehouse.model.Movie;
import com.ticketapp.sfmoviehouse.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Iterable<Event> findAll() {
        Iterable<Event> events = eventRepository.findAll();
        return events;
    }

}
