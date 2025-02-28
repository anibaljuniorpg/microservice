package com.anibal.events_microservice.service;

import com.anibal.events_microservice.domain.Event;
import com.anibal.events_microservice.domain.Subscription;
import com.anibal.events_microservice.dtos.EmailRequestDTO;
import com.anibal.events_microservice.dtos.EventRequestDTO;
import com.anibal.events_microservice.exceptions.EventFullException;
import com.anibal.events_microservice.exceptions.EventNotFoundException;
import com.anibal.events_microservice.repository.EventRepository;
import com.anibal.events_microservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    private EmailServiceClient emailServiceClient;
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    public List<Event> getUpcomingEvent(){
        return eventRepository.findUpcomingEvents(LocalDateTime.now());
    }
    public Event createEvent(EventRequestDTO eventRequestDTO){
        Event newEvent = new Event(eventRequestDTO);
        return eventRepository.save(newEvent);
    }

    public void registerParticipant(String eventId, String participantEmail){
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);

        if (!isEventFull(event)){
            Subscription subscription = new Subscription(event,participantEmail);
            subscriptionRepository.save(subscription);

            event.setRegisteredParticipants(event.getRegisteredParticipants() + 1);

            EmailRequestDTO emailRequestDTO = new EmailRequestDTO(participantEmail, "Confirmação de Inscrição", "Você foi incrito no evento com sucesso" );

            emailServiceClient.sendEmail(emailRequestDTO);
        } else{
            throw new EventFullException();
        }
    }
    private Boolean isEventFull(Event event){
        return event.getMaxParticipantes() <= event.getRegisteredParticipants();
    }
}
