package com.queHacer.queHacer.ReviewPlace.Exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlaceReviewExceptions {

    INVALID_RATING("Rating must be between 0 and 5"),
    REVIEW_ALREADY_SUBMITTED("You have already submitted a review for this item"),
    REVIEW_NOT_FOUND("Review not found for the specified ID"),
    MISSING_REVIEW_CONTENT("Review content cannot be empty")
    ;

    private final String message;
}
