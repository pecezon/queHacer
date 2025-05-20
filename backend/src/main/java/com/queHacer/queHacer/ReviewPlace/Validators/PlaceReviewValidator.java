package com.queHacer.queHacer.ReviewPlace.Validators;

import com.queHacer.queHacer.ReviewPlace.Exceptions.InvalidPlaceReviewException;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewExceptions;
import com.queHacer.queHacer.ReviewPlace.Model.CreatePlaceReviewDTO;

public class PlaceReviewValidator {

    public static void validate(CreatePlaceReviewDTO input){
        if(input.getRating() < 0 || input.getRating() > 5){
            throw new InvalidPlaceReviewException(PlaceReviewExceptions.INVALID_RATING.getMessage());
        }
    }
}
