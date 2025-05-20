package com.queHacer.queHacer.Place.Model;

import lombok.Getter;

@Getter
public class PlaceErrorResponse {
    private String message;

    public PlaceErrorResponse(String message) {
        this.message = message;
    }
}
