package com.egon89.application.category.delete;

import com.egon89.category.CategoryGateway;
import com.egon89.category.CategoryID;

import java.util.Objects;

public class DefaultDeleteCategoryUseCase extends DeleteCategoryUseCase {
  private final CategoryGateway categoryGateway;

  public DefaultDeleteCategoryUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public void execute(String input) {
    this.categoryGateway.deleteById(CategoryID.from(input));
  }
}
