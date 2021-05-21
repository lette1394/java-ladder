package com.github.lette1394;

import static com.github.lette1394.Contracts.requires;

import java.util.Objects;

public class Named implements Point {
  private final String name;

  public Named(String name) {
    requires(name != null, "이름은 반드시 존재해야 합니다");
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Named)) {
      return false;
    }
    Named named = (Named) o;
    return Objects.equals(name, named.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
