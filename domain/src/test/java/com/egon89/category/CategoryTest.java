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

  @Test
  public void givenAnInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final var expectedName = "  ";
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "name should not be empty";
    final var expectedDescription = "description";
    final var expectedIsActive = true;
    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var actualException =
        Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
    Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());

  }

  @Test
  public void givenAnInvalidNameLengthLessThan3_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final var expectedName = "mo ";
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "name must be between 3 and 255 characters";
    final var expectedDescription = "description";
    final var expectedIsActive = true;
    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var actualException =
        Assertions.assertThrows(DomainException.class, () ->actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
    Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());

  }

  @Test
  public void givenAnInvalidNameLengthMoreThan255_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final var expectedName = """
                Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                when an unknown printer took a galley of type and scrambled it to make a type specimen book.
                It has survived not only five centuries, but also the leap into electronic typesetting,
                remaining essentially unchanged.
                """;

    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "name must be between 3 and 255 characters";
    final var expectedDescription = "description";
    final var expectedIsActive = true;
    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var actualException =
        Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
    Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());

  }

  @Test
  public void givenAValidEmptyDescription_whenCallNewCategoryAndValidate_thenShouldReceiveOK() {

    final var expectedName = "movie";
    final var expectedDescription = "  ";
    final var expectedIsActive = true;
    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));
    Assertions.assertNotNull(actualCategory);
    Assertions.assertNotNull(actualCategory.getId());
    Assertions.assertEquals(expectedName, actualCategory.getName());
    Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
    Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
    Assertions.assertNotNull(actualCategory.getCreatedAt());
    Assertions.assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNull(actualCategory.getDeletedAt());
  }

  @Test
  public void givenAValidFalseIsActive_whenCallNewCategoryAndValidate_thenShouldReceiveOK() {

    final var expectedName = "movie";
    final var expectedDescription = "description";
    final var expectedIsActive = false;
    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));
    Assertions.assertNotNull(actualCategory);
    Assertions.assertNotNull(actualCategory.getId());
    Assertions.assertEquals(expectedName, actualCategory.getName());
    Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
    Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
    Assertions.assertNotNull(actualCategory.getCreatedAt());
    Assertions.assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNotNull(actualCategory.getDeletedAt());
  }
}