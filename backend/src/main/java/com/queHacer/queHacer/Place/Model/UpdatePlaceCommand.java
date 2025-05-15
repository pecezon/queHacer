package com.queHacer.queHacer.Place.Model;

import lombok.Getter;

@Getter
public class UpdatePlaceCommand {
    private final Long id;
    private final UpdatePlaceDTO updatePlaceDTO;

    public UpdatePlaceCommand(Long id, UpdatePlaceDTO updatePlaceDTO) {
        this.id = id;
        this.updatePlaceDTO = updatePlaceDTO;
    }
}
