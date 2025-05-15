package com.queHacer.queHacer.PlaceSchedule.Exceptions;

import lombok.Getter;

@Getter
public enum PlaceScheduleErrorMessages {

    DAY_OF_WEEK_REQUIRED("Day of the week is required."),

    OPENING_TIME_REQUIRED("Opening time can't be empty."),
    CLOSING_TIME_REQUIRED("Closing time can't be empty."),

    OPENING_OR_CLOSING_TIME_MISSING("Both opening and closing time are required."),
    OPENING_EQUALS_CLOSING("Opening and closing time can't be the same."),
    OPENING_AFTER_CLOSING("Opening time can't be after closing time."),

    DUPLICATE_DAY("Day of the week already registered."),
    INVALID_TIME_FORMAT("Invalid time format (must be HH:mm)."),

    SCHEDULE_NOT_FOUND("Required schedule was not found."),
    SCHEDULE_DOES_NOT_BELONG_TO_PLACE("Schedule must belong to a place.");

    private final String message;
    PlaceScheduleErrorMessages(String message) {
        this.message = message;
    }
}
