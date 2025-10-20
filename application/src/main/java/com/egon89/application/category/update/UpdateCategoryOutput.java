package com.egon89.application.category.update;

import com.egon89.category.Category;
import com.egon89.category.CategoryID;

public record UpdateCategoryOutput(
    CategoryID id
) {

  public static UpdateCategoryOutput from(final Category aCategory) {
    return new UpdateCategoryOutput(aCategory.getId());
  }
}
