package org.example.objects.objectutils.compareobjects;

import org.apache.commons.lang3.ObjectUtils;

public class CompareObjectsExample {
  public static void main(String[] args) {
    Integer num1 = 10;
    Integer num2 = 20;
    Integer num3 = null;

    // Compare two numbers
    int compareResult = ObjectUtils.compare(num1, num2);
    System.out.println("Comparison result (10 vs 20): " + compareResult); // Output: -1 (10 < 20)

    // Compare with a null value (null is considered less than a non-null value)
    int compareWithNull = ObjectUtils.compare(num3, num1);
    System.out.println("Comparison result (null vs 10): " + compareWithNull); // Output: -1

    // Check if two objects are equal
    boolean isEqual = ObjectUtils.equals(num1, 10);
    System.out.println("Is 10 equal to 10? " + isEqual); // Output: true

    // Check if two objects are not equal
    boolean isNotEqual = ObjectUtils.notEqual(num1, num2);
    System.out.println("Is 10 not equal to 20? " + isNotEqual); // Output: true
  }
}
/*
Comparing Objects
These methods help compare objects safely, handling null values correctly.
 */
