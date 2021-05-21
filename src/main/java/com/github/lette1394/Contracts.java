package com.github.lette1394;

import static java.lang.String.format;

public final class Contracts {
  public static void requires(boolean truthy, String message, Object... arguments) {
    if (truthy) {
      return;
    }
    throw new ContractsViolationException(format(message, arguments));
  }
}

