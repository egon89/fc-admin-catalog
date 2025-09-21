package com.egon89;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UseCaseTest {

  @Test
  void shouldExecute() {
    Assertions.assertNotNull(new UseCase());
    Assertions.assertNotNull(new UseCase().execute());
  }
}