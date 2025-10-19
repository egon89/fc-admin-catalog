package com.egon89.application.category.create;

import com.egon89.application.UseCase;
import com.egon89.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase
    extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
