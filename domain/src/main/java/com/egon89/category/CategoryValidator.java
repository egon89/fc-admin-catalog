package com.egon89.category;

import com.egon89.validation.Error;
import com.egon89.validation.ValidationHandler;
import com.egon89.validation.Validator;

import java.util.Objects;

public class CategoryValidator extends Validator {
  private final Category category;

  public CategoryValidator(
      final Category category,
      final ValidationHandler handler
  ) {
    super(handler);
    this.category = category;
  }

  @Override
  public void validate() {
    checkNameConstraints();
  }

  private void checkNameConstraints() {
    final var name = this.category.getName();

    if (Objects.isNull(name)) {
      validationHandler().append(
          Error.from("name should not be null")
      );

      return;
    }

    if (name.isBlank()) {
      validationHandler().append(
          Error.from("name should not be empty")
      );

      return;
    }

    final int length = name.trim().length();
    if (length < 3 || length > 255) {
      validationHandler().append(
          Error.from("name must be between 3 and 255 characters")
      );
    }
  }
}
