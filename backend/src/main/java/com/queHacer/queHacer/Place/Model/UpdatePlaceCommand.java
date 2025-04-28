package com.queHacer.queHacer.Place.Model;

import lombok.Getter;

@Getter
public class UpdatePlaceCommand {
    private Long id;
    private Place place;

    public UpdatePlaceCommand(Long id, Place place) {
        this.id = id;
        this.place = place;
    }
}
