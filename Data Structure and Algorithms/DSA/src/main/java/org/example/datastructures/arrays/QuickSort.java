package org.example.datastructures.arrays;

import java.util.Arrays;

public class QuickSort {
  /*
  Quicksort Algorithm:

  How it works:
  - Quicksort is a divide-and-conquer sorting algorithm that works by partitioning an array into two smaller sub-arrays, one with elements less than the pivot and one with elements greater than the pivot.
  1. A pivot element is chosen (in this implementation, the last element in the array).
  2. All elements smaller than or equal to the pivot are moved to its left, and all larger elements to its right (achieved using the partition method).
  3. The pivot element is swapped into its correct sorted position, splitting the array into two sub-arrays.
  4. The above steps are applied recursively to the left and right sub-arrays until the entire array is sorted.

  Manual Walkthrough:
  - Given an array [64, 34, 25, 12, 22, 11, 90, 5]:
    1. Pivot = 5 → Partition around pivot → Split into [ ] and [64, 34, 25, 12, 22, 11, 5 | 90]
    2. Recursively apply QuickSort on left [ ] and right [64, 34, ..., 5]
    3. Continue until all sub-arrays are of size 0 or 1.

  Time Complexity:
  - Best/Average Case: O(n log n) [Array is divided evenly at each step].
  - Worst Case: O(n^2) [Occurs when array is already sorted or reverse-sorted with a bad pivot choice].
  */
  // Partition function:
  // - Selects the pivot element (last element of the array).
  // - Rearranges the array so that all elements smaller than or equal to the pivot
  //   are to its left, and all larger elements are to its right.
  // - Swaps the pivot into its correct position and returns its index.
  public static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i += 1;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return i + 1;
  }

  // QuickSort function:
  // - Divides the array into two sub-arrays based on the pivot index.
  // - Recursively sorts the sub-arrays to the left and right of the pivot.
  // - Stops when the sub-array size is 0 or 1, as these are inherently sorted.
  public static void quicksort(int[] array, int low, int high) {
    if (low < high) {
      int pivot_index = partition(array, low, high);
      quicksort(array, low, pivot_index - 1);
      quicksort(array, pivot_index + 1, high);
    }
  }

  // Overloaded quicksort function to handle the default high value
  public static void quicksort(int[] array) {
    quicksort(array, 0, array.length - 1);
  }

  public static void main(String[] args) {
    int[] my_array = {64, 34, 25, 12, 22, 11, 90, 5};
    double startTime = System.currentTimeMillis();
    System.out.println("Original array: " + Arrays.toString(my_array));
    quicksort(my_array);
    System.out.println("Sorted array: " + Arrays.toString(my_array));
    double endTime = System.currentTimeMillis();
    System.out.println("Time taken: " + (endTime - startTime) + " seconds");
  }
}
