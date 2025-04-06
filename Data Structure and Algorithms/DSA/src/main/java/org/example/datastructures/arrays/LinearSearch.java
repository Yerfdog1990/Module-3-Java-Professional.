package org.example.datastructures.arrays;

import java.util.*;

public class LinearSearch {
  /*
   Linear Search Algorithm:
   - Linear Search is a straightforward method to locate a target value within an array.
   - It works by iterating through the array sequentially and comparing each element with the target value.

   Steps:
   1. Start at the first index of the array.
   2. Check if the current element matches the target value.
   3. If a match is found, return the index of the matching element.
   4. If the search reaches the end of the array without finding a match, return -1.

   Characteristics:
   - It is easy to implement and requires no additional space.
   - Best for small or unsorted arrays.

   Time Complexity:
   - Best case: O(1), when the target value is at the first index.
   - Worst case: O(n), when the target value is not found or is at the last index.
   - Average case: O(n), where 'n' is the size of the array.
  */

  // Function to perform linear search on the array
  public static int linearSearch(int[] arr, int targetVal) {
    // Loop through the array
    for (int i = 0; i < arr.length; i++) {
      // Check if the current element equals the target value
      if (arr[i] == targetVal) {
        return i;
      }
    }
    // Return -1 if the target value is not found in the array
    return -1;
  }

  public static void main(String[] args) {
    // Initialize the array
    int[] arr = {3, 7, 2, 9, 5};
    // Set the target value to search for
    int targetVal = 9;

    // Call the linearSearch function and store the result
    int result = linearSearch(arr, targetVal);

    // Check if the result indicates that the target was found
    if (result != -1) {
      System.out.println("Value " + targetVal + " found at index " + result);
    } else {
      System.out.println("Value " + targetVal + " not found");
    }
  }
}
