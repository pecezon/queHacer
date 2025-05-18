package com.queHacer.queHacer.Event.Model;

import lombok.Getter;

@Getter
public class UpdateEventCommand {
    private Integer id;
    private UpdateEventDTO updateEventDTO;

    public UpdateEventCommand(Integer id, UpdateEventDTO updateEventDTO) {
        this.id = id;
        this.updateEventDTO = updateEventDTO;
    }
}
