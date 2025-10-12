package com.egon89.application;

public abstract class UnitUseCase<IN> {
  public abstract void execute(IN input);
}
