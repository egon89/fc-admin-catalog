package com.egon89.validation;

import java.util.List;
import java.util.Objects;

public interface ValidationHandler {

  ValidationHandler append(Error error);

  ValidationHandler append(ValidationHandler validationHandler);

  ValidationHandler validate(Validation validation);

  List<Error> getErrors();

  default boolean hasError() {
    return Objects.nonNull(getErrors()) && !getErrors().isEmpty();
  }

  default Error firstError() {
    if (Objects.isNull(getErrors()) || getErrors().isEmpty()) {
      return null;
    }

    return getErrors().getFirst();
  }

  interface Validation {
    void validate();
  }
}
