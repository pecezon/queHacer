package com.queHacer.queHacer.Event.Model;

import lombok.Getter;

@Getter
public class UpdateEventCommand {
    private Integer id;
    private Event event;

    public UpdateEventCommand(Integer id, Event event) {
        this.id = id;
        this.event = event;
    }
}
