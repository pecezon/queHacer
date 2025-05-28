package com.queHacer.queHacer.ReviewEvent.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewEventNotFoundException extends RuntimeException{
    public ReviewEventNotFoundException(){
        super(ErrorMessages.REVIEW_EVENT_NOT_FOUND.getMessage());
    }
}
