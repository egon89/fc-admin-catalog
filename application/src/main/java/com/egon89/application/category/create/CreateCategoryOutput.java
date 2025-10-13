package com.egon89.application.category.create;

import com.egon89.category.Category;
import com.egon89.category.CategoryID;

public record CreateCategoryOutput(
    CategoryID id
) {

  public static CreateCategoryOutput from(final Category category) {
    return new CreateCategoryOutput(category.getId());
  }
}
