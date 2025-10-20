package com.egon89.category;

import com.egon89.validation.Error;
import com.egon89.validation.ValidationHandler;
import com.egon89.validation.Validator;

import java.util.Objects;

public class CategoryValidator extends Validator {
  public static final int NAME_MAX_LENGTH = 255;
  public static final int NAME_MIN_LENGTH = 3;
  public static final String CATEGORY_NOT_FOUND = "Category with ID %s was not found";

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
    if (length < NAME_MIN_LENGTH || length > NAME_MAX_LENGTH) {
      validationHandler().append(
          Error.from(
              String.format("name must be between %d and %d characters", NAME_MIN_LENGTH, NAME_MAX_LENGTH ))
      );
    }
  }
}
