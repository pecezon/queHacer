package com.queHacer.queHacer.Event.Exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),
    NAME_REQUIRED("Name is required"),
    DESCRIPTION_LENGTH("Description length must be over 20 characters"),
    MINIMUM_PRICE_CANNOT_BE_NEGATIVE("Minimum price should be listed and bigger than zero (0.00)"),
    MAXIMUM_PRICE_NOT_LESSER_THAT_MINIMUM("Maximum price should be listed and no lesser than the minimum price"),
    START_DAY_REQUIRED_AND_NOT_BEFORE_TODAY("Start date should be listed and it must be after todays date"),
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
