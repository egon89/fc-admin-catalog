package com.egon89.application.category.update;

import com.egon89.application.UseCase;
import com.egon89.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase
    extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
