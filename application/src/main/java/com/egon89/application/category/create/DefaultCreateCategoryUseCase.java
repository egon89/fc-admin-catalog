package com.egon89.application.category.create;

import com.egon89.category.Category;
import com.egon89.category.CategoryGateway;
import com.egon89.validation.handler.ThrowsValidationHandler;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

  private final CategoryGateway categoryGateway;

  public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public CreateCategoryOutput execute(final CreateCategoryCommand command) {
    final var category = Category.newCategory(command.name(), command.description(), command.isActive());
    category.validate(new ThrowsValidationHandler());

    return CreateCategoryOutput.from(this.categoryGateway.create(category));
  }
}
