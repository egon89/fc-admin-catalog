package com.egon89.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryTest {

  @Test
  public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
    final var expectedName = "Test";
    final var expectedDescription = "Category description";
    final var expectedIsActive = true;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    assertNotNull(actualCategory);
    assertNotNull(actualCategory.getId());
    assertEquals(expectedName, actualCategory.getName());
    assertEquals(expectedDescription, actualCategory.getDescription());
    assertEquals(expectedIsActive, actualCategory.isActive());
    assertNotNull(actualCategory.getCreatedAt());
    assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNull(actualCategory.getDeletedAt());
  }
}