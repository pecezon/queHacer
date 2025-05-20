package com.queHacer.queHacer.PlaceSchedule.Model;

import lombok.*;

import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceScheduleDTO {
    private Long id;
    private DayOfTheWeek dayOfTheWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;
    public PlaceScheduleDTO(PlaceSchedule placeSchedule) {
        this.id = placeSchedule.getId();
        this.dayOfTheWeek = placeSchedule.getDayOfTheWeek();
        this.openingTime = placeSchedule.getOpeningTime();
        this.closingTime = placeSchedule.getClosingTime();
    }

}
