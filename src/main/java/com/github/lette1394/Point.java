package com.github.lette1394;

import static com.github.lette1394.Contracts.requires;
import static java.lang.Math.min;
import static java.lang.Math.toIntExact;
import static java.lang.String.format;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

import java.util.List;
import java.util.Objects;

public class Point {
  private final String value;

  public Point(String value) {
    requires(value != null, "이름은 반드시 존재해야 합니다");
    requires(value.length() > 0, "이름은 한 글자 이상 작성해야 합니다");
    this.value = value;
  }

  public Point above(Point that) {
    final Point widenThis = this.widen(that);
    final Point widenThat = that.widen(this);
    return new Point(format("%s%s%s", widenThis, lineSeparator(), widenThat));
  }

  public Point beside(Point that) {
    final List<String> thisLines = this.heighten(that).toString().lines().collect(toList());
    final List<String> thatLines = that.heighten(this).toString().lines().collect(toList());

    final String next = range(0, min(thisLines.size(), thatLines.size()))
      .mapToObj(i -> thisLines.get(i) + thatLines.get(i))
      .collect(joining(lineSeparator()));
    return new Point(next);
  }

  public Point widen(Point that) {
    final int maximum = that.toString().lines().findAny().map(String::length).orElse(0);
    final int current = this.toString().lines().findAny().map(String::length).orElse(0);
    if (current >= maximum) {
      return this;
    }

    final String append = Character.toString(value.charAt(0)).repeat(maximum - current);
    final String next = this.toString().lines()
      .map(base -> base + append)
      .collect(joining(lineSeparator()));
    return new Point(next);
  }

  public Point heighten(Point that) {
    int maximum = toIntExact(that.toString().lines().count());
    int current = toIntExact(this.toString().lines().count());
    if (current >= maximum) {
      return this;
    }

    return new Point(rangeClosed(0, maximum - current)
      .mapToObj(__ -> toString())
      .collect(joining(lineSeparator())));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Point)) {
      return false;
    }
    Point point = (Point) o;
    return Objects.equals(value, point.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }
}
