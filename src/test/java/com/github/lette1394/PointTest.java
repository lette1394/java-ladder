package com.github.lette1394;

import static com.github.lette1394.StringPointMatcher.isString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PointTest {
  private static final String ANY_NAME = "pobi";

  @Test
  void 이름이_같으면_서로_같다() {
    assertThat(new Point(ANY_NAME), is(new Point(ANY_NAME)));
  }

  @Test
  void 이름이_될_수_없는_값들() {
    assertThrows(ContractsViolationException.class, () -> new Point(null));
    assertThrows(ContractsViolationException.class, () -> new Point(""));
  }

  @Test
  void toString은_이름을_표현한다() {
    assertThat(new Point(ANY_NAME), isString(ANY_NAME));
  }

  @Test
  void above() {
    final Point up = new Point("aa");
    final Point down = new Point("bbbb");

    assertThat(up.above(down), isString("aaaa\nbbbb"));
  }

  @Test
  void above2D() {
    final Point up = new Point(""
      + "aaa\n"
      + "aaa\n"
      + "aaa");
    final Point down = new Point(""
      + "bbbbb\n"
      + "bbbbb");

    assertThat(up.above(down), isString(""
      + "aaaaa\n"
      + "aaaaa\n"
      + "aaaaa\n"
      + "bbbbb\n"
      + "bbbbb"));
  }

  @Test
  void beside() {
    final Point left = new Point("left");
    final Point right = new Point("right");

    assertThat(left.beside(right), isString("leftright"));
  }

  @Test
  void beside2D() {
    final Point left = new Point(""
      + "aaa\n"
      + "aaa\n"
      + "aaa");
    final Point right = new Point(""
      + "bbbbb\n"
      + "bbbbb");

    assertThat(left.beside(right), isString(""
      + "aaabbbbb\n"
      + "aaabbbbb\n"
      + "aaabbbbb"));
  }

  @Test
  void widen() {
    final Point base = new Point("a");
    final Point width = new Point("width");

    assertThat(base.widen(width), isString("aaaaa"));
  }

  @Test
  void heighten() {
    final Point base = new Point("base");
    final Point height = new Point(""
      + "line1\n"
      + "line2");

    assertThat(base.heighten(height), isString("base\nbase"));
  }

  @Test
  void square() {
    final Point root = new Point("a");
    final Point width = new Point("    ");
    final Point height = new Point("\n\n\n\n");

    final Point square = root.widen(width).heighten(height);
    assertThat(square, isString(""
      + "aaaa\n"
      + "aaaa\n"
      + "aaaa\n"
      + "aaaa"));
  }
}