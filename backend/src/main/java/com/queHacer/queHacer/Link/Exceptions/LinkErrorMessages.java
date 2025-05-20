package com.queHacer.queHacer.Link.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LinkErrorMessages {
    LINK_NOT_FOUND("The link requested was not found."),
    INVALID_LINK("The link requested is not valid or not longer available."),
    MISSING_URL("url ir required."),
    EVENT_NOT_FOUND("The required event was not found.");

    private final String message;
}
