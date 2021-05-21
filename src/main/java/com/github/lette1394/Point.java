package com.github.lette1394;

public interface Point {
  Point above(Point that);

  Point beside(Point that);

  Point widen(Point that);

  Point heighten(Point that);
}
