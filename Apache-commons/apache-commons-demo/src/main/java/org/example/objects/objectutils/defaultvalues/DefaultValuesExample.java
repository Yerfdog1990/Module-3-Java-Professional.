package org.example.objects.objectutils.defaultvalues;

import org.apache.commons.lang3.ObjectUtils;

public class DefaultValuesExample {
  public static void main(String[] args) {
    String str = null;

    // If str is null, return "Default Value"
    String result = ObjectUtils.defaultIfNull(str, "Default Value");
    System.out.println("Default value when null: " + result); // Output: Default Value

    // Find the first non-null value
    String firstValid = ObjectUtils.firstNonNull(null, null, "First", "Second");
    System.out.println("First non-null value: " + firstValid); // Output: First
  }
}
/*
Providing Default Values
These methods help prevent NullPointerException by returning a default value when encountering null.
 */
