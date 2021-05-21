package com.github.lette1394;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NamedTest {

  @Test
  void 서로_같음_기준() {
    final Point point1 = new Named("pobi");
    final Point point2 = new Named("pobi");
    assertThat(point1, is(point2));
  }

  @Test
  void 이름에_들어갈_수_있는_값() {
    assertThrows(ContractsViolationException.class, () -> new Named(null));
    assertThrows(ContractsViolationException.class, () -> new Named(""));
  }

  @Test
  void toString은_이름을_표현한다() {
    final Point point = new Named("pobi");
    assertThat(point.toString(), is("pobi"));
  }
}