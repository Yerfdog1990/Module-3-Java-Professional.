package org.example.datastructures.arrays;

import java.util.Arrays;

public class MergeSort {
  /*
   Merge Sort Algorithm:
   - Merge Sort is a recursive, divide-and-conquer sorting algorithm.
   - It divides the input array into two halves, recursively sorts each half,
     and then merges the two sorted halves into a single sorted array.

   How it works:
   1. Divide:
      - The input array is split into two smaller sub-arrays (left and right) using the middle index.
      - This process continues recursively until each sub-array contains only one element (which is inherently sorted).
   2. Conquer:
      - Two sorted sub-arrays are merged into a single sorted array. During this process:
        - The smallest element from either sub-array is chosen and placed in the resulting array.
        - This continues until all elements from both sub-arrays are placed in order.
   3. Combine:
      - After merging all sub-arrays, the final sorted array is obtained.

   Time Complexity:
   - The time complexity is O(n * log n) where:
     - `n` is the number of elements in the input array.
     - The `log n` factor comes from the number of levels of recursion needed to divide the array.
   - Space Complexity: O(n), as additional space is required to store the merged sub-arrays.
  */

  // Method 1: Merge Sort with Recursion
  private static final int[] intArray1 = {19, 22, 0, 13, 4, 35};

  public static int[] recursiveMergeSort(int[] intArray1) {
    if (intArray1.length <= 1) {
      return intArray1;
    }

    int mid = intArray1.length / 2;
    int[] leftHalf1 = Arrays.copyOfRange(intArray1, 0, mid);
    int[] rightHalf1 = Arrays.copyOfRange(intArray1, mid, intArray1.length);

    int[] sortedLeft1 = recursiveMergeSort(leftHalf1);
    int[] sortedRight1 = recursiveMergeSort(rightHalf1);
    return merge1(sortedLeft1, sortedRight1);
  }

  public static int[] merge1(int[] left2, int[] right2) {
    int[] result1 = new int[left2.length + right2.length];
    int i = 0, j = 0, k = 0;

    while (i < left2.length && j < right2.length) {
      if (left2[i] < right2[j]) {
        result1[k] = left2[i];
        i += 1;
      } else {
        result1[k] = right2[j];
        j += 1;
      }
      k += 1;
    }

    while (i < left2.length) {
      result1[k] = left2[i];
      i += 1;
      k += 1;
    }

    while (j < right2.length) {
      result1[k] = right2[j];
      j += 1;
      k += 1;
    }

    return result1;
  }

  // Method 2: Merge Sort without Recursion
  private static final int[] intArray2 = {19, 22, 0, 13, 4, 35};

  // Function to merge two sorted arrays
  private static int[] merge2(int[] left, int[] right) {
    // Initialize result array with the combined length of left and right
    int[] result2 = new int[left.length + right.length];
    int m = 0, n = 0, index = 0;

    // While both arrays have elements, pick the smaller element from each
    while (m < left.length && n < right.length) {
      if (left[m] < right[n]) {
        result2[index] = left[m];
        m += 1;
      } else {
        result2[index] = right[n];
        n += 1;
      }
      index += 1;
    }

    // Extend result with any remaining elements from left
    while (m < left.length) {
      result2[index] = left[m];
      m += 1;
      index += 1;
    }

    // Extend result with any remaining elements from right
    while (n < right.length) {
      result2[index] = right[n];
      n += 1;
      index += 1;
    }

    return result2;
  }

  // Function to perform merge sort on the array iteratively
  public static int[] nonRecursiveMergeSort(int[] intArray2) {
    int step = 1; // Starting with sub-arrays of length 1
    int length = intArray2.length;

    // Iteratively increase the size of sub-arrays and merge them
    while (step < length) {
      for (int i = 0; i < length; i += 2 * step) {
        // Get the left sub-array from arr[i] to arr[i + step]
        int[] left2 = Arrays.copyOfRange(intArray2, i, Math.min(i + step, length));
        // Get the right sub-array from arr[i + step] to arr[i + 2 * step]
        int[] right2 = Arrays.copyOfRange(intArray2, i + step, Math.min(i + 2 * step, length));

        // Merge the left and right sub-arrays
        int[] merged = merge2(left2, right2);

        // Place the merged array back into the original array
        for (int j = 0; j < merged.length; j++) {
          intArray2[i + j] = merged[j];
        }
      }
      step *= 2; // int the sub-array length for the next iteration
    }

    return intArray2;
  }

  public static void main(String[] args) {
    double startTime1 = System.currentTimeMillis();
    System.out.println("Unsorted array: " + Arrays.toString(intArray1));
    System.out.print("Sorted array: " + Arrays.toString(recursiveMergeSort(intArray1)));
    double endTime1 = System.currentTimeMillis();
    System.out.println("\nTime taken using method 1: " + (endTime1 - startTime1) + " seconds");
    System.out.println();
    double startTime2 = System.currentTimeMillis();
    System.out.println("Unsorted array: " + Arrays.toString(intArray2));
    System.out.print("Sorted array: " + Arrays.toString(nonRecursiveMergeSort(intArray2)));
    double endTime2 = System.currentTimeMillis();
    System.out.println("\nTime taken using method 2: " + (endTime2 - startTime2) + " seconds");
  }
}
