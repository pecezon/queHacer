package com.queHacer.queHacer.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TagNotValidException extends RuntimeException {
    public TagNotValidException() {
        super(ErrorMessages.INVALID_TAG_INFO.getMessage());
    }
}
