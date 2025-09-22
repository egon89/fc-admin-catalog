package com.egon89.validation;

public record Error(String message) {
  public static Error from(String message) {
    return new Error(message);
  }
}
