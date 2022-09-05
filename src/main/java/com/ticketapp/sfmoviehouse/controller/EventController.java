package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Event;
import com.ticketapp.sfmoviehouse.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/events")
    public ResponseEntity getEvent() {
        Iterable<Event> events = eventService.findAll();
        return ResponseEntity.ok(events);
    }


}
