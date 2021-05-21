package com.github.lette1394;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class DotTest {
  private static final char ANY_CHAR = ' ';

  @Test
  void char_같으면_서로_같다() {
    final Point dot1 = new Dot(ANY_CHAR);
    final Point dot2 = new Dot(ANY_CHAR);
    assertThat(dot1, is(dot2));
  }

  @Test
  void toString은_char를_표현한다() {
    final Point dot = new Dot(ANY_CHAR);
    assertThat(dot.toString(), is(Character.toString(ANY_CHAR)));
  }
}