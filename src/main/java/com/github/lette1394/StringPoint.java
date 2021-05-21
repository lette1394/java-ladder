package com.github.lette1394;

import static com.github.lette1394.Contracts.requires;
import static java.lang.String.format;

import java.util.Objects;

public class StringPoint implements Point {
  private final String value;

  public StringPoint(String value) {
    requires(value != null, "이름은 반드시 존재해야 합니다");
    requires(value.length() > 0, "이름은 한 글자 이상 작성해야 합니다");
    this.value = value;
  }

  public static Point line(int size) {
    return new StringPoint(" ".repeat(size));
  }

  @Override
  public Point above(Point other) {
    return new StringPoint(format("%s\n%s", this, other));
  }

  @Override
  public Point beside(Point other) {
    return new StringPoint(format("%s%s", this, other));
  }

  @Override
  public Point widen(Point other) {
    final int maximum = other.toString().length();
    final int current = toString().length();
    if (current >= maximum) {
      return this;
    }
    return new StringPoint(String.format("%s%s", value, " ".repeat(maximum - current)));
  }

  @Override
  public Point heighten(Point other) {
    return null;
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
