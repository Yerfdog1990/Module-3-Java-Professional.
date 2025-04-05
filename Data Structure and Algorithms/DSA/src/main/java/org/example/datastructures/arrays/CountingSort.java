package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort {
  /*
   How it works:
   Counting Sort is an efficient algorithm for sorting a collection of non-negative integers.
   It involves the following main steps:

   1. Create a counting array to count the occurrences of each value in the input array.
      The size of this array is determined by the maximum value in the input array.
   2. Iterate through the input array, incrementing the counters in the counting array for each value encountered.
   3. Construct the sorted array using the counting array, by iterating over the counts and adding each value according to its count.

   Conditions for Counting Sort:
   - Can only be applied to non-negative integers because each value corresponds directly to an index in the counting array.
   - Best suited for scenarios where the range of values (k) is not significantly larger than the number of elements in the array (n).

   Time Complexity:
   - Best, average, and worst case: O(n + k), where n is the number of elements in the input array and k is the range of input values.
   - Space complexity: O(k), due to the size of the counting array.
  */
  private static ArrayList<Integer> intArray = new ArrayList<>(List.of(19, 22, 0, 13, 4, 35));
  private static int maxValue = Collections.max(intArray);
  private static int[] countArray = new int[maxValue + 1];

  private static int[] countingSort() {
    while (intArray.size() > 0) {
      int num = intArray.remove(0);
      countArray[num]++;
    }
    for (int i = 1; i < countArray.length; i++) {
      while (countArray[i] > 0) {
        intArray.add(i);
        countArray[i]--;
      }
    }
    return intArray.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    System.out.println("Unsorted array: " + intArray);
    System.out.println("Sorted array: " + Arrays.toString(countingSort()));
  }
}
