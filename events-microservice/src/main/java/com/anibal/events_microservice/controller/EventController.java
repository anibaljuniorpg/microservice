package com.anibal.events_microservice.controller;

import com.anibal.events_microservice.domain.Event;
import com.anibal.events_microservice.dtos.EventRequestDTO;
import com.anibal.events_microservice.dtos.SubscriptionRequestDTO;
import com.anibal.events_microservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;;
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/upcomimg")
    public List<Event> getUpcomingEvents(){
        return eventService.getUpcomingEvent();
    }

    @PostMapping
    public Event createEvent(@RequestBody EventRequestDTO eventRequestDTO){
        return eventService.createEvent(eventRequestDTO);
    }

    @PostMapping("/{eventId}/register")
    public void registerParticipant(@PathVariable String eventId, @RequestBody SubscriptionRequestDTO requestDTO){
        eventService.registerParticipant(eventId, requestDTO.partipantEmail());
    }
}
