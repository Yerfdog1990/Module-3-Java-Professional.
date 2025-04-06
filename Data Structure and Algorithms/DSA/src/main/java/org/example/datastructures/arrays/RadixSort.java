package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
  /*
   Radix Sort Explanation:
   Radix Sort is a non-comparative sorting algorithm that processes digits of numbers in a specific order, starting from the least significant digit (LSD).
   The algorithm ensures stable sorting by grouping items at each digit level before moving to the next digit.

   Steps to Implement:
   1. Identify the largest number in the array to determine the maximum number of digits (k) to be processed.
   2. Start with the least significant digit (ones place) and sort all integers into buckets (0-9) based on their value for that position.
   3. Collect numbers back in order of the buckets, preserving their relative order (stability).
   4. Repeat the process for the next more significant digit, such as tens place, hundreds place, and so on.
   5. Continue steps 2-4 until all digits in the largest number are processed.

   Time Complexity:
   - Radix Sort processes every number k times (for k digits) with n operations per pass (n being the number of elements to sort).
   - This gives a total time complexity of O(n * k).
   - Best Case: O(n), when k is small relative to n.
   - Worst Case: O(n^2), when k is comparable to n.
   - Typical Case: O(n * log(n)), when k relates logarithmically to n (e.g., for numbers with up to log(n) digits).
  */
  // Step 1: Create and display the original list
  private static ArrayList<Integer> intArray =
      new ArrayList<>(List.of(170, 45, 75, 90, 802, 24, 2, 66));
  private static int maxNum = intArray.get(0);

  private static void radixSort() {
    // Step 2: Find the largest number (to know how many digits we need to sort by)
    for (int num : intArray) {
      if (num > maxNum) {
        maxNum = num;
      }
    }
    // Step 3: Sorting starts with the least significant digit (1s, 10s, 100s, ...)
    int place = 1; // 1, 10, 100, ...

    // Keep sorting until we've sorted by the largest digit place
    while (maxNum / place > 1) {
      // Step 4: Create 10 buckets for digits 0 to 9
      List<List<Integer>> bucketList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        bucketList.add(new ArrayList<>());
      }
      // Step 5: Place each number into the correct bucket based on the current digit
      for (int num : intArray) {
        int digit = num / place % 10;
        bucketList.get(digit).add(num);
      }
      // Step 6: Rebuild the numbers list by collecting numbers from the buckets
      intArray.clear(); // Clear original list
      for (List<Integer> bucket : bucketList) {
        intArray.addAll(bucket); // Add numbers back in order
      }
      // Step 7: Move to the next digit place
      place *= 10;
    }
  }

  public static void main(String[] args) {
    System.out.println("Original array: " + intArray);
    radixSort();
    System.out.println("Sorted array: " + intArray);
  }
}
