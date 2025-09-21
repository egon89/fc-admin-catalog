package com.egon89;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  void shouldExecuteMain() {
    Assertions.assertNotNull(new Main());
    Main.main(new String[]{});
  }
}