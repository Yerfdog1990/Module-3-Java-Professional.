package org.example.datastructures.arrays;

import java.util.*;

public class LinearSearch {

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
