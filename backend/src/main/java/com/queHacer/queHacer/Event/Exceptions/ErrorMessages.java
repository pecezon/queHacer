package com.queHacer.queHacer.Event.Exceptions;

public enum ErrorMessages {
    EVENT_NOT_FOUND("Event Not Found"),
    NAME_REQUIRED("Name is required"),
    DESCRIPTION_LENGTH("Description length must be over 20 characters"),
    INVALID_MINIMUM_PRICE("Valid minimum price should be specified"),
    INVALID_MAXIMUM_PRICE("Valid maximum price should be specified"),
    MAXIMUM_PRICE_NOT_LESS_THAT_MINIMUM("Maximum price should be no less than  minimum price"),
    START_DAY_REQUIRED_AND_NOT_BEFORE_TODAY("Start date should be listed and it must be after today's date"),
    END_DAY_NOT_BEFORE_START("End day must be after start day"),
    STREET_REQUIRED("Street adress is required"),
    CITY_REQUIRED("City is required"),
    COUNTY_REQUIRED("County is required"),
    COUNTRY_REQUIRED("Country is required"),
    PHONE_NUMBER_REQUIRED("A phone number is required");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
