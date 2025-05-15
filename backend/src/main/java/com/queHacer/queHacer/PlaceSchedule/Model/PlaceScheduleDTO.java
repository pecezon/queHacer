package com.queHacer.queHacer.PlaceSchedule.Model;

import lombok.*;

import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceScheduleDTO {
    private DayOfTheWeek dayOfTheWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;
    public PlaceScheduleDTO(PlaceSchedule placeSchedule) {
        this.dayOfTheWeek = placeSchedule.getDayOfTheWeek();
        this.openingTime = placeSchedule.getOpeningTime();
        this.closingTime = placeSchedule.getClosingTime();
    }

}
