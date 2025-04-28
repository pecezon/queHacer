package com.queHacer.queHacer.Place.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException() {
        super(PlaceErrorMessages.PLACE_NOT_FOUND.getMessage());
    }
}
