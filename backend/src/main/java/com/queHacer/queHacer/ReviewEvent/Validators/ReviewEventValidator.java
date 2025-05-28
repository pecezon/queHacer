package com.queHacer.queHacer.ReviewEvent.Validators;

import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.Exceptions.ReviewEventNotValidException;

public class ReviewEventValidator {

    private ReviewEventValidator(){

    }

    public static void execute(ReviewEvent reviewEvent){
        if (reviewEvent.getRating() <0.0 || reviewEvent.getRating()>5.0){
            throw new ReviewEventNotValidException("Description must be between 0 and 5");
        }
    }
}
