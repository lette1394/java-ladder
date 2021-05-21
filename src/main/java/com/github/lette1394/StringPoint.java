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
  public Point above(Point that) {
    return new StringPoint(format("%s\n%s", this, that));
  }

  @Override
  public Point beside(Point that) {
    return new StringPoint(format("%s%s", this, that));
  }

  @Override
  public Point widen(Point that) {
    final int maximum = that.toString().length();
    final int current = this.toString().length();
    if (current >= maximum) {
      return this;
    }
    return new StringPoint(format("%s%s", value, " ".repeat(maximum - current)));
  }

  @Override
  public Point heighten(Point that) {
    int maximum = that.toString().split("\n").length;
    int current = this.toString().split("\n").length;
    if (current >= maximum) {
      return this;
    }
    return new StringPoint(format("%s%s", value, "\n".repeat(maximum - current)));
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
