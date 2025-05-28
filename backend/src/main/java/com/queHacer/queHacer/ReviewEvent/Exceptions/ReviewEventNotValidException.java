package com.queHacer.queHacer.ReviewEvent.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReviewEventNotValidException extends RuntimeException{

    public ReviewEventNotValidException(String message){
        super(message);
    }
}
