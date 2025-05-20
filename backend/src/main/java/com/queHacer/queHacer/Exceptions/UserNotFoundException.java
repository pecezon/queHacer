package com.queHacer.queHacer.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
