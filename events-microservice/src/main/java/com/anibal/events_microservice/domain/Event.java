package com.anibal.events_microservice.domain;

import com.anibal.events_microservice.dtos.EventRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "event")
@Table(name="event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int maxParticipantes;
    private int registeredParticipants;
    private String date;
    private String title;
    private String description;

    public Event(EventRequestDTO eventRequestDTO){
        this.date = eventRequestDTO.date();
        this.maxParticipantes = eventRequestDTO.maxParticipantes();
        this.description = eventRequestDTO.description();
        this.title = eventRequestDTO.title();
        this.registeredParticipants = eventRequestDTO.registeredParticipants();
    }

}
