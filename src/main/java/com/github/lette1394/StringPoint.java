package com.github.lette1394;

import static com.github.lette1394.Contracts.requires;
import static java.lang.Math.min;
import static java.lang.Math.toIntExact;
import static java.lang.String.format;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class StringPoint implements Point {
  private final String value;

  public StringPoint(String value) {
    requires(value != null, "이름은 반드시 존재해야 합니다");
    requires(value.length() > 0, "이름은 한 글자 이상 작성해야 합니다");
    this.value = value;
  }

  @Override
  public Point above(Point that) {
    final Point widenThis = this.widen(that);
    final Point widenThat = that.widen(this);
    return new StringPoint(format("%s%s%s", widenThis, lineSeparator(), widenThat));
  }

  @Override
  public Point beside(Point that) {
    final List<String> thisLines = this.heighten(that).toString().lines().collect(toList());
    final List<String> thatLines = that.heighten(this).toString().lines().collect(toList());

    return new StringPoint(IntStream.range(0, min(thisLines.size(), thatLines.size()))
      .mapToObj(i -> thisLines.get(i) + thatLines.get(i))
      .collect(joining(lineSeparator())));
  }

  @Override
  public Point widen(Point that) {
    final int maximum = that.toString().lines().findAny().map(String::length).orElse(0);
    final int current = this.toString().lines().findAny().map(String::length).orElse(0);
    if (current >= maximum) {
      return this;
    }

    final String append = Character.toString(value.charAt(0)).repeat(maximum - current);
    return new StringPoint(this.toString().lines()
      .map(base -> base + append)
      .collect(joining(lineSeparator())));
  }

  @Override
  public Point heighten(Point that) {
    int maximum = toIntExact(that.toString().lines().count());
    int current = toIntExact(this.toString().lines().count());
    if (current >= maximum) {
      return this;
    }

    return new StringPoint(rangeClosed(0, maximum - current)
      .mapToObj(__ -> toString())
      .collect(joining(lineSeparator())));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StringPoint)) {
      return false;
    }
    StringPoint stringPoint = (StringPoint) o;
    return Objects.equals(value, stringPoint.value);
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
