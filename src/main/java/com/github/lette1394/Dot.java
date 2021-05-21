package com.github.lette1394;

import java.util.Objects;

public class Dot implements Point {
  private final char ch;

  public Dot(char ch) {
    this.ch = ch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Dot)) {
      return false;
    }
    Dot dot = (Dot) o;
    return ch == dot.ch;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ch);
  }

  @Override
  public String toString() {
    return Character.toString(ch);
  }
}
