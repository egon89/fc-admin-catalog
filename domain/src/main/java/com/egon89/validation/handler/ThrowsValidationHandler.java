package com.egon89.validation.handler;

import com.egon89.exceptions.DomainException;
import com.egon89.validation.Error;
import com.egon89.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
  @Override
  public ValidationHandler append(final Error error) {
    throw DomainException.with(List.of(error));
  }

  @Override
  public ValidationHandler append(ValidationHandler validationHandler) {
    throw DomainException.with(validationHandler.getErrors());
  }

  @Override
  public ValidationHandler validate(Validation validation) {
    try {
      validation.validate();
    } catch (Exception ex) {
      final var error = Error.from(ex.getMessage());
      throw DomainException.with(List.of(error));
    }

    return this;
  }

  @Override
  public List<Error> getErrors() {
    return List.of();
  }
}
