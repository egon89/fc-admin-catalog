package com.egon89.exceptions;

import com.egon89.validation.Error;

import java.util.List;
import java.util.function.Supplier;

public class DomainException extends NoStackTraceException {
  private final List<Error> errors;

  private DomainException(final String message, List<Error> errors) {
    super(message);
    this.errors = errors;
  }

  public static DomainException with(final List<Error> errors) {
    return new DomainException("", errors);
  }

  public static DomainException with(final Error error) {
    return new DomainException(error.message(), List.of(error));
  }

  static public Supplier<DomainException> notFound(final String message) {
    return () -> DomainException.with(new Error(message));
  }

  public List<Error> getErrors() {
    return errors;
  }
}
