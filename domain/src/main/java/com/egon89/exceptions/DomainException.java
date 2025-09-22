package com.egon89.exceptions;

import com.egon89.validation.Error;

import java.util.List;

public class DomainException extends RuntimeException {
  private final List<Error> errors;

  private DomainException(List<Error> errors) {
    super("", null, true, false);
    this.errors = errors;
  }

  public static DomainException with(final List<Error> errors) {
    return new DomainException(errors);
  }

  public List<Error> getErrors() {
    return errors;
  }
}
