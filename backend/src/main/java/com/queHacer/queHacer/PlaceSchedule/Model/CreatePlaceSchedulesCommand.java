package com.queHacer.queHacer.PlaceSchedule.Model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatePlaceSchedulesCommand {
    private Long placeId;
    private List<CreatePlaceScheduleDTO> schedules;
}
