package com.queHacer.queHacer.Exceptions;

public enum ErrorMessages {
    USER_NOT_FOUND("User not found man"),
    USER_BAD_REQUEST("Te faltan datos o ingresate algo mal perro"),
    NAME_REQUIRED("User name is required"),
    LASTNAME_REQUIRED("User lastname is required"),
    EMAIL_REQUIRED("User email is required"),
    EMAIL_EXISTS("User email is already being used"),
    PHONE_REQUIRED("User phone number is required"),
    PHONE_LENGTH_NOT_VALID("The users phone number needs to be at least 10 digits long");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
