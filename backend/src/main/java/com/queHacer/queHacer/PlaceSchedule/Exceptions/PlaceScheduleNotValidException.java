package com.queHacer.queHacer.PlaceSchedule.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlaceScheduleNotValidException extends RuntimeException {
    public PlaceScheduleNotValidException(String message) {
        super(message);
    }
}
