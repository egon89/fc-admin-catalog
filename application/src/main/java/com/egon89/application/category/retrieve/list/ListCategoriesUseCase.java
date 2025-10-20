package com.egon89.application.category.retrieve.list;

import com.egon89.application.UseCase;
import com.egon89.category.CategorySearchQuery;
import com.egon89.pagination.Pagination;

public abstract class ListCategoriesUseCase
  extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
