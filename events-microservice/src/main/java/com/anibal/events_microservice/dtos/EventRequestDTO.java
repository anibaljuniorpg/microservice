package com.anibal.events_microservice.dtos;

public record EventRequestDTO(int maxParticipantes, int registeredParticipants , String date, String title, String description) {
}
