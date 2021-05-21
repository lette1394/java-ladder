package com.github.lette1394;

public interface Point {
  Point above(Point other);

  Point beside(Point other);

  Point widen(Point other);

  Point heighten(Point other);
}
