package com.egon89.category;

import com.egon89.AggregateRoot;
import com.egon89.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {
  private final String name;
  private final String description;
  private final boolean active;
  private final Instant createdAt;
  private final Instant updatedAt;
  private final Instant deletedAt;

  private Category(
      final CategoryID id,
      final String name,
      final String description,
      final boolean active,
      final Instant createdAt,
      final Instant updatedAt,
      final Instant deletedAt
  ) {
    super(id);
    this.name = name;
    this.description = description;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
    final var id = CategoryID.unique();

    final var now = Instant.now();

    final var deletedAt = isActive ? null : now;

    return new Category(id, aName, aDescription, isActive, now, now, deletedAt);

  }

  @Override
  public void validate(ValidationHandler handler) {
    new CategoryValidator(this, handler).validate();
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActive() {
    return active;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }
}
