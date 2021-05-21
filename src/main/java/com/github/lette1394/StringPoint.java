package com.github.lette1394;

import static com.github.lette1394.Contracts.requires;

import java.util.Objects;

public class StringPoint implements Point {
  private final String value;

  public StringPoint(String value) {
    requires(value != null, "이름은 반드시 존재해야 합니다");
    requires(value.length() > 0, "이름은 한 글자 이상 작성해야 합니다");
    this.value = value;
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
