package com.github.lette1394;

import static com.github.lette1394.StringPointMatcher.isString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StringPointTest {
  private static final String ANY_NAME = "pobi";

  @Test
  void 이름이_같으면_서로_같다() {
    final Point point1 = new StringPoint(ANY_NAME);
    final Point point2 = new StringPoint(ANY_NAME);
    assertThat(point1, is(point2));
  }

  @Test
  void 이름이_될_수_없는_값들() {
    assertThrows(ContractsViolationException.class, () -> new StringPoint(null));
    assertThrows(ContractsViolationException.class, () -> new StringPoint(""));
  }

  @Test
  void toString은_이름을_표현한다() {
    final Point point = new StringPoint(ANY_NAME);
    assertThat(point, isString(ANY_NAME));
  }

  @Test
  void above() {
    final Point up = new StringPoint("up");
    final Point down = new StringPoint("down");
    assertThat(up.above(down), isString("up\ndown"));
  }

  @Test
  void beside() {
    final Point left = new StringPoint("left");
    final Point right = new StringPoint("right");
    assertThat(left.beside(right), isString("leftright"));
  }

  @Test
  void widen() {
    final Point point1 = new StringPoint("base");
    final Point point2 = new StringPoint("widen");
    assertThat(point1.widen(point2), isString("base "));
  }
}