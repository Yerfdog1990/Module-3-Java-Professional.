package org.example.objects.objectutils.nullhandling;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtilsExample {
  public static void main(String[] args) {
    String str1 = null;
    String str2 = "Hello";
    String str3 = null;

    // Check if all values are null
    boolean allAreNull = ObjectUtils.allNull(str1, str3); // true
    System.out.println("Are all values null? " + allAreNull);

    // Check if all values are non-null
    boolean allNotNull = ObjectUtils.allNotNull(str1, str2); // false
    System.out.println("Are all values non-null? " + allNotNull);

    // Check if any value is null
    boolean anyNull = ObjectUtils.anyNull(str1, str2); // true
    System.out.println("Is any value null? " + anyNull);

    // Check if at least one value is not null
    boolean anyNotNull = ObjectUtils.anyNotNull(str1, str2, str3); // true
    System.out.println("Is any value not null? " + anyNotNull);
  }
}
/*
Null Handling Methods
These methods help check if objects are null or not, ensuring null safety in your code.
 */
