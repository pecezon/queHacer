package com.queHacer.queHacer.ReviewEvent.Exceptions;

public enum ErrorMessages {

    REVIEW_EVENT_NOT_FOUND("REVIEW EVENT NOT FOUND"),
    REVIEW_EVENT_NOT_VALID("REVIEW EVENT INVALID");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
