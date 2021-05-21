package com.github.lette1394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NamedTest {

  @Test
  void 서로_같음_기준() {
    final Point point1 = new Named("pobi");
    final Point point2 = new Named("pobi");
    assertThat(point1, is(point2));
  }
}