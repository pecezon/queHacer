package com.queHacer.queHacer.PlaceSchedule.Model;

import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePlaceScheduleDTO {

    private DayOfTheWeek dayOfTheWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;

}
