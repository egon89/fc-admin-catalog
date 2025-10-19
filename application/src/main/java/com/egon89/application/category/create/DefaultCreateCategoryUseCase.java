package com.egon89.application.category.create;

import com.egon89.category.Category;
import com.egon89.category.CategoryGateway;
import com.egon89.validation.handler.Notification;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

  private final CategoryGateway categoryGateway;

  public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand command) {
    final var notification = Notification.create();

    final var category = Category.newCategory(command.name(), command.description(), command.isActive());

    category.validate(notification);

    return notification.hasError() ? Either.left(notification) : create(category);
  }

  private Either<Notification, CreateCategoryOutput> create(final Category category) {
    return Try.ofSupplier(() -> this.categoryGateway.create(category))
        .toEither()
        .bimap(Notification::create, CreateCategoryOutput::from);
  }
}
