package com.queHacer.queHacer.PlaceSchedule.Validators;

import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleErrorMessages;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleNotValidException;
import com.queHacer.queHacer.PlaceSchedule.Model.DayOfTheWeek;
import com.queHacer.queHacer.PlaceSchedule.Model.CreatePlaceScheduleDTO;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlaceScheduleValidators {

    public static void validate(CreatePlaceScheduleDTO dto){
        DayOfTheWeek day = dto.getDayOfTheWeek();
        LocalTime opening = dto.getOpeningTime();
        LocalTime closing = dto.getClosingTime();

        //Day of the week is required
        if(day == null){
            throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.DAY_OF_WEEK_REQUIRED.getMessage());
        }

        //validate that both opening and closing time are present
        if((opening != null && closing == null) || (opening == null && closing != null)){
            throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.OPENING_OR_CLOSING_TIME_MISSING.getMessage());
        }

        //validate format of opening and closing time in case of being present
        if(opening != null && closing != null){
            //Validate that closing is after opening
            if(opening.isAfter(closing)){
                throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.OPENING_AFTER_CLOSING.getMessage());
            }
            //Validate that they are not the same
            if(opening.equals(closing)){
                throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.OPENING_EQUALS_CLOSING.getMessage());
            }
        }

    }
    public static void validateScheduleList(List<CreatePlaceScheduleDTO> schedule){
        Set<DayOfTheWeek> days = new HashSet<>();
        //Validate set of schedules sent by client
        for (CreatePlaceScheduleDTO current : schedule) {
            validate(current);
            if (!days.add(current.getDayOfTheWeek())) {
                throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.DUPLICATE_DAY.getMessage() + ": " + current.getDayOfTheWeek() );
            }
        }
    }
}
