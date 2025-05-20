package com.queHacer.queHacer.Link.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidLinkException extends RuntimeException {
  public InvalidLinkException(String message) {
    super(message);
  }
}
