package com.queHacer.queHacer.PlaceSchedule.Model;

import lombok.Getter;

@Getter
public class PlaceScheduleErrorResponse {
    private final String message;

    public PlaceScheduleErrorResponse(String message) {
        this.message = message;
    }
}
