package com.queHacer.queHacer.Event.validators;

import com.queHacer.queHacer.Event.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Event.Exceptions.EventNotValidException;
import com.queHacer.queHacer.Event.Model.Event;
import io.micrometer.common.util.StringUtils;

import java.time.LocalDateTime;

public class EventValidator {
    private EventValidator(){

    }

    public static void execute(Event event){
        if (StringUtils.isEmpty(event.getName())){
            throw new EventNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if (event.getDescription().length() < 20){
            throw new EventNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if (event.getMinPrice() == null || event.getMinPrice()< 0.00){
            throw new EventNotValidException(ErrorMessages.MINIMUM_PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }

        if (event.getMaxPrice() == null || event.getMaxPrice() < event.getMinPrice()){
            throw new EventNotValidException(ErrorMessages.MAXIMUM_PRICE_NOT_LESSER_THAT_MINIMUM.getMessage());
        }

        if (event.getStartDate() == null || event.getStartDate().isBefore(LocalDateTime.now())){
            throw new EventNotValidException(ErrorMessages.START_DAY_REQUIRED_AND_NOT_BEFORE_TODAY.getMessage());
        }

        if (StringUtils.isEmpty(event.getStreet())){
            throw new EventNotValidException(ErrorMessages.STREET_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(event.getCity())){
            throw new EventNotValidException(ErrorMessages.CITY_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(event.getCounty())){
            throw new EventNotValidException(ErrorMessages.COUNTY_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(event.getCountry())){
            throw new EventNotValidException(ErrorMessages.COUNTRY_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(event.getPhone())){
            throw new EventNotValidException(ErrorMessages.PHONE_NUMBER_REQUIRED.getMessage());
        }
    }
}
