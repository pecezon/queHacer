package com.queHacer.queHacer.ReviewPlace.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaceReviewNotFound extends RuntimeException {
    public PlaceReviewNotFound(String message) {
        super(message);
    }
}
