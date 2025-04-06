package org.example.datastructures.arrays;

public class BinarySearch {
  /*
  Binary Search Algorithm:

  Binary Search is a highly efficient algorithm used to search for a target value within a sorted array.
  It works by repeatedly dividing the search interval in half until the target value is found or the search interval is empty.

  Steps:
  1. Find the middle element in the current search range.
  2. If the middle element matches the target, return its index.
  3. If the target value is smaller than the middle element, narrow the search to the left half.
  4. If the target value is larger, narrow the search to the right half.
  5. Repeat this process until the target is found or the range is invalid.

  Time Complexity:
  - Best case: O(1), when the target is found at the first comparison.
  - Average and worst case: O(log n), due to the halving of the search range at each step.
  */

  // Binary search method
  public static int binarySearch(int[] arr, int targetVal) {
    int left = 0;
    int right = arr.length - 1;

    // Continue searching while there is a valid range
    while (left <= right) {
      int mid = (left + right) / 2;

      if (arr[mid] == targetVal) {
        return mid; // Found the target
      }

      if (arr[mid] < targetVal) {
        left = mid + 1; // Search the right half
      } else {
        right = mid - 1; // Search the left half
      }
    }

    return -1; // Target not found
  }

  public static void main(String[] args) {
    int[] myArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    int myTarget = 15;

    int result = binarySearch(myArray, myTarget);

    if (result != -1) {
      System.out.println("Value " + myTarget + " found at index " + result);
    } else {
      System.out.println("Target not found in array.");
    }
  }
}
