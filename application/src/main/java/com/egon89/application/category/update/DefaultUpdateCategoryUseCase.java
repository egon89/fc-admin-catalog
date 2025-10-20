package com.egon89.application.category.update;

import com.egon89.category.Category;
import com.egon89.category.CategoryGateway;
import com.egon89.category.CategoryID;
import com.egon89.category.CategoryValidator;
import com.egon89.exceptions.DomainException;
import com.egon89.validation.handler.Notification;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.Objects;

public class DefaultUpdateCategoryUseCase extends UpdateCategoryUseCase {
  private final CategoryGateway categoryGateway;

  public DefaultUpdateCategoryUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public Either<Notification, UpdateCategoryOutput> execute(UpdateCategoryCommand input) {
    final var category = this.categoryGateway.findById(CategoryID.from(input.id()))
        .orElseThrow(DomainException.notFound(CategoryValidator.CATEGORY_NOT_FOUND.formatted(input.id())));

    final var notification = Notification.create();

    category.update(
        input.name(),
        input.description(),
        input.isActive()
    ).validate(notification);

    return notification.hasError() ? Either.left(notification) : update(category);
  }

  private Either<Notification, UpdateCategoryOutput> update(final Category category) {
    return Try.ofSupplier(() -> this.categoryGateway.update(category))
        .toEither()
        .bimap(Notification::create, UpdateCategoryOutput::from);
  }
}
