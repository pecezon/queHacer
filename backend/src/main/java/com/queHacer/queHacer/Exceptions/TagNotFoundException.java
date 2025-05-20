package com.queHacer.queHacer.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException() {
        super(ErrorMessages.TAG_NOT_FOUND.getMessage());
    }
}
