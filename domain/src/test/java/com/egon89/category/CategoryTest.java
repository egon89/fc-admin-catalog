package com.egon89.category;

import com.egon89.exceptions.DomainException;
import com.egon89.validation.handler.ThrowsValidationHandler;
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

  @Test
  public void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "name should not be null";
    final var expectedDescription = "Category description";
    final var expectedIsActive = true;
    final var actualCategory =
        Category.newCategory(null, expectedDescription, expectedIsActive);

    final var actualException =
        Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());

    Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());

  }
}