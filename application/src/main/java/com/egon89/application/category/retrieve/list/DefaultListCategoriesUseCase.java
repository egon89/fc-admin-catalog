package com.egon89.application.category.retrieve.list;

import com.egon89.category.CategoryGateway;
import com.egon89.category.CategorySearchQuery;
import com.egon89.pagination.Pagination;

import java.util.Objects;

public class DefaultListCategoriesUseCase extends ListCategoriesUseCase {
  private final CategoryGateway categoryGateway;

  public DefaultListCategoriesUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public Pagination<CategoryListOutput> execute(final CategorySearchQuery query) {
    return this.categoryGateway.findAll(query)
        .map(CategoryListOutput::from);
  }
}
