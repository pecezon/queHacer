package com.queHacer.queHacer.Event.validators;

import com.queHacer.queHacer.Event.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Event.Exceptions.EventNotValidException;
import com.queHacer.queHacer.Event.Exceptions.InvalidSearchEventException;
import com.queHacer.queHacer.Event.Model.DateRangeCommand;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateRangeValidator {

    private DateRangeValidator(){

    }

    public static void execute(DateRangeCommand command){

        if (command.getStartDate() == null){
            command.setStartDate(LocalDate.now());
        }

        if (command.getEndDate() == null){
            command.setEndDate(LocalDate.from(command.getStartDate().atTime(LocalTime.MAX)));
        }

        if(command.getStartDate() == null || command.getStartDate().isBefore(LocalDate.now())){
            throw new InvalidSearchEventException(ErrorMessages.START_DAY_REQUIRED_AND_NOT_BEFORE_TODAY.getMessage());
        }

        if (command.getEndDate().isBefore(command.getStartDate())){
            throw new InvalidSearchEventException(ErrorMessages.END_DAY_NOT_BEFORE_START.getMessage());
        }

    }
}
