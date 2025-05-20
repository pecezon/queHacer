package com.queHacer.queHacer.ReviewPlace.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPlaceReviewException extends RuntimeException {
  public InvalidPlaceReviewException(String message) {
    super(message);
  }
}
