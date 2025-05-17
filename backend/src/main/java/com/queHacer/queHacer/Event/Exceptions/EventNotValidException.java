package com.queHacer.queHacer.Event.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventNotValidException extends RuntimeException {

    public EventNotValidException(String message){
        super(message);
    }
}
