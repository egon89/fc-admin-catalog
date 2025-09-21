package com.egon89;

import com.egon89.category.Category;

public class UseCase {
  public Category execute() {
    return Category.newCategory("Category A", "description", true);
  }
}
