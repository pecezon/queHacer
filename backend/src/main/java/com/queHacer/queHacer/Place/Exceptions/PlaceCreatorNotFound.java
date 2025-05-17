package com.queHacer.queHacer.Place.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaceCreatorNotFound extends RuntimeException {
    public PlaceCreatorNotFound() {
        super(PlaceErrorMessages.PLACE_CREATOR_NOT_FOUND.getMessage());
    }
}
