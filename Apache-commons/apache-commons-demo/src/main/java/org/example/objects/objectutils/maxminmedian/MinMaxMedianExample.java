package org.example.objects.objectutils.maxminmedian;

import org.apache.commons.lang3.ObjectUtils;

public class MinMaxMedianExample {
  public static void main(String[] args) {
    Integer a = 5, b = 10, c = 3, d = 7;

    // Find the smallest value
    Integer minValue = ObjectUtils.min(a, b, c, d);
    System.out.println("Minimum value: " + minValue); // Output: 3

    // Find the largest value
    Integer maxValue = ObjectUtils.max(a, b, c, d);
    System.out.println("Maximum value: " + maxValue); // Output: 10

    // Find the median value
    Integer medianValue = ObjectUtils.median(a, b, c, d);
    System.out.println("Median value: " + medianValue); // Output: 6 (average of 5 and 7)
  }
}

/*
Finding Min, Max, and Median
These methods help find the smallest, largest, and middle values.
 */
