package com.queHacer.queHacer.Place.Validators;

import com.queHacer.queHacer.Place.Exceptions.InvalidPlaceSearchException;
import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotValidException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.SearchPlaceByCityAndCountryCommand;
import io.micrometer.common.util.StringUtils;


public class PlaceValidator {

    public PlaceValidator() {
    }
    public static void execute(Place place){
        if(StringUtils.isEmpty(place.getName())){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_NAME_REQUIRED.getMessage());
        }
        if(place.getDescription().length() < 20){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_DESCRIPTION_REQUIRED.getMessage());
        }
        if(place.getPriceRange() == null || place.getPriceRange() < 0.00){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_PRICE_RANGE_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(place.getStreet())){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_STREET_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(place.getCp())){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_CP_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(place.getCounty())) {
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_COUNTY_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(place.getCountry())){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_COUNTRY_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(place.getCity())){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_CITY_REQUIRED.getMessage());
        }


    }
    public static void validateCityAndCountry(SearchPlaceByCityAndCountryCommand input) {
        if (input.getCity() == null || input.getCity().isBlank()) {
            throw new InvalidPlaceSearchException(PlaceErrorMessages.PLACE_CITY_REQUIRED.getMessage());
        }
        if (input.getCountry() == null || input.getCountry().isBlank()) {
            throw new InvalidPlaceSearchException(PlaceErrorMessages.PLACE_COUNTRY_REQUIRED.getMessage());
        }
    }
}
