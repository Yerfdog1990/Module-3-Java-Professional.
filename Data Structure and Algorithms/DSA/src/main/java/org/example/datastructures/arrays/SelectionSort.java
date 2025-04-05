package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
  /*
  How it works:
  - Selection Sort is a simple sorting algorithm that divides the input array into two parts: a sorted portion and an unsorted portion.
  - The outer loop ensures the algorithm scans the array n-1 times (where n is the size of the array).
  - The inner loop iterates through the unsorted portion of the array, identifies the minimum value, and moves it to the front by removing it and inserting it at its correct position in the sorted portion.
  - This process repeats, decreasing the size of the unsorted portion and growing the sorted portion until the entire array is sorted.

  Time Complexity:
  - Best, average, and worst-case time complexity: O(n^2).
  - The algorithm always requires O(n^2) comparisons, regardless of the input data's initial order.

  Selection Sort Shifting Problem:
  - During the sorting process, elements are removed from their current position in the array and inserted at the front.
  - Every removal causes subsequent elements in the array to shift left, and every insertion causes elements to shift right to make room.
  - Although these shifting operations are abstracted away by high-level languages (e.g., Python, Java), they still happen behind the scenes and can significantly impact performance due to the additional time required for these operations.
  */
  private static ArrayList<Integer> intArray = new ArrayList<>(List.of(19, 22, 0, 13, 4, 35));
  private static int n = intArray.size();

  private static void selectionSort() {
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i; j < n - 1; j++) {
        if (intArray.get(j) < intArray.get(minIndex)) {
          minIndex = j;
        }
      }
      int minValue = intArray.remove(minIndex);
      intArray.add(i, minValue);
    }
    System.out.print(intArray);
  }

  public static void main(String[] args) {
    System.out.println("Unsorted array: " + intArray);
    System.out.print("Sorted array: ");
    selectionSort();
  }
}
