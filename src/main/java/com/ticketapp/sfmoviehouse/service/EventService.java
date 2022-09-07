package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.model.Event;
import com.ticketapp.sfmoviehouse.model.Movie;
import com.ticketapp.sfmoviehouse.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Event> findById(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return eventRepository.findById(id);
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public void deleteById(long id) {
        if (!eventRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        eventRepository.deleteById(id);
    }

    public void updateEvent(Long id, Event updatedEvent) {
        if (!eventRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        Event event = eventRepository.findById(id).get();
        event.setDate(updatedEvent.getDate());
        event.setCinema(updatedEvent.getCinema());
        eventRepository.save(event);
    }
}
