package com.queHacer.queHacer.Exceptions;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException() {
        super(ErrorMessages.TAG_NOT_FOUND.getMessage());
    }
}
