package com.anibal.events_microservice.exceptions;

public class EventFullException extends  RuntimeException{
    public EventFullException(){
        super("Evento esta lotado");
    }
    public EventFullException(String message){
        super(message);
    }
}
