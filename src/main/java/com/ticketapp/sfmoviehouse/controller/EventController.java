package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.model.Event;
import com.ticketapp.sfmoviehouse.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/events")
public class EventController {


    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getEvents() {

        return ResponseEntity.ok().body(eventService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok().body(eventService.findById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addEvent(@RequestBody Event event) {
        eventService.save(event);
        return ResponseEntity.ok("added event");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.ok("removed event");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        eventService.updateEvent(id, event);
        return ResponseEntity.ok("updated event");
    }


}
