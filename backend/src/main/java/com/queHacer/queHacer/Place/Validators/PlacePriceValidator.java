package com.queHacer.queHacer.Place.Validators;

import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotValidException;
import com.queHacer.queHacer.Place.Model.SearchPlacesByPriceRangeCommand;

public class PlacePriceValidator {

    public static void execute(SearchPlacesByPriceRangeCommand command){
        //In case min or max price are missing, set to default values
        if(command.getMinPrice() == null){
            command.setMinPrice(0.0f);
        }
        if(command.getMaxPrice() == null){
            command.setMaxPrice(Float.MAX_VALUE);
        }
        //

        if(command.getMinPrice() < 0.0 || command.getMinPrice() > Float.MAX_VALUE){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_INVALID_MIN_PRICE.getMessage());
        }
        if(command.getMinPrice() > command.getMaxPrice()){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_PRICE_RANGE_REQUIRED.getMessage());
        }
        if(command.getMaxPrice() < 0.0 || command.getMaxPrice() > Float.MAX_VALUE){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_INVALID_MAX_PRICE.getMessage());
        }

    }
}
