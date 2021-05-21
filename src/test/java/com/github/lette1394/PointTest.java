package com.github.lette1394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PointTest {

  @Test
  void equals() {
    final Point point1 = new Point();
    final Point point2 = new Point();
    assertThat(point1, is(point2));
  }
}