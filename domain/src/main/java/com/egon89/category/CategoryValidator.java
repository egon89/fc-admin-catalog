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
    if (Objects.isNull(category.getName())) {
      validationHandler().append(
          Error.from("name should not be null")
      );
    }
  }
}
