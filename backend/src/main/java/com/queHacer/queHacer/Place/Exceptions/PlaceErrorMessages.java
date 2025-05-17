package com.queHacer.queHacer.Place.Exceptions;


import lombok.Getter;

@Getter
public enum PlaceErrorMessages {

    PLACE_NOT_FOUND("Place not found."),
    PLACE_NAME_REQUIRED("Name of the place is required."),
    PLACE_DESCRIPTION_REQUIRED("Description must be at least 20 characters long."),
    PLACE_PRICE_RANGE_REQUIRED("Valid price range is required"),
    PLACE_STREET_REQUIRED("The street is required."),
    PLACE_CP_REQUIRED("The postal code is required."),
    PLACE_COUNTY_REQUIRED("The county is required."),
    PLACE_CITY_REQUIRED("The city is required."),
    PLACE_COUNTRY_REQUIRED("The country is required."),
    PLACE_CREATOR_NOT_FOUND("The user was not found"),
    PLACE_INVALID_MIN_PRICE("Valid minimum price is required"),
    PLACE_INVALID_MAX_PRICE("Valid maximum price is required");


    private final String message;


    PlaceErrorMessages(String message) {
        this.message = message;
    }

}
