package com.egon89.application.category.retrieve.get;

import com.egon89.category.CategoryGateway;
import com.egon89.category.CategoryID;
import com.egon89.category.CategoryValidator;
import com.egon89.exceptions.DomainException;

import java.util.Objects;

public class DefaultGetCategoryByIdUseCase extends GetCategoryByIdUseCase {
  private final CategoryGateway categoryGateway;

  public DefaultGetCategoryByIdUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public CategoryOutput execute(final String input) {
    final var categoryID = CategoryID.from(input);

    return this.categoryGateway.findById(categoryID)
        .map(CategoryOutput::from)
        .orElseThrow(
            DomainException.notFound(CategoryValidator.CATEGORY_NOT_FOUND.formatted(input)));
  }
}
