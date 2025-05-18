package com.queHacer.queHacer.Event.validators;

import com.queHacer.queHacer.Event.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Event.Exceptions.InvalidSearchEventException;
import com.queHacer.queHacer.Event.Model.EventPriceCommand;

public class PriceRangeValidator {
    private PriceRangeValidator(){

    }

    public static void execute(EventPriceCommand eventPriceCommand){

        if (eventPriceCommand.getMinPrice() == null){
            eventPriceCommand.setMinPrice(0.0f);
        }

        if (eventPriceCommand.getMaxPrice() == null){
            eventPriceCommand.setMaxPrice(Float.MAX_VALUE);
        }

        if (eventPriceCommand.getMinPrice() < 0.00 || eventPriceCommand.getMinPrice() > Float.MAX_VALUE){
            throw new InvalidSearchEventException(ErrorMessages.INVALID_MINIMUM_PRICE.getMessage());
        }

        if (eventPriceCommand.getMaxPrice() < 0.00 || eventPriceCommand.getMaxPrice() > Float.MAX_VALUE){
            throw new InvalidSearchEventException(ErrorMessages.INVALID_MAXIMUM_PRICE.getMessage());
        }

        if (eventPriceCommand.getMinPrice() > eventPriceCommand.getMaxPrice()){
            throw new InvalidSearchEventException(ErrorMessages.MAXIMUM_PRICE_NOT_LESS_THAT_MINIMUM.getMessage());
        }
    }
}
