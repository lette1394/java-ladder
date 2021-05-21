package com.github.lette1394;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NamedTest {
  private static final String ANY_NAME = "pobi";

  @Test
  void 이름이_같으면_서로_같다() {
    final Point point1 = new Named(ANY_NAME);
    final Point point2 = new Named(ANY_NAME);
    assertThat(point1, is(point2));
  }

  @Test
  void 이름이_될_수_없는_값들() {
    assertThrows(ContractsViolationException.class, () -> new Named(null));
    assertThrows(ContractsViolationException.class, () -> new Named(""));
  }

  @Test
  void toString은_이름을_표현한다() {
    final Point point = new Named(ANY_NAME);
    assertThat(point.toString(), is(ANY_NAME));
  }
}