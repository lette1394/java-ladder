package com.github.lette1394;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class StringPointMatcher {
  public static Matcher<Point> isString(String expected) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(Point item, Description mismatchDescription) {
        if (item.toString().equals(expected)) {
          return true;
        }
        mismatchDescription.appendValue(item.toString());
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description.appendValue(expected);
      }
    };
  }
}
