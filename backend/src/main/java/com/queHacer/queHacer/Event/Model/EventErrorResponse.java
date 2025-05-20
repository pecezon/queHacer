package com.queHacer.queHacer.Event.Model;

import lombok.Getter;

@Getter
public class EventErrorResponse {
    private String message;

    public EventErrorResponse(String message) {
        this.message = message;
    }
}
