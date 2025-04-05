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
  private static ArrayList<Integer> IntArray1 = new ArrayList<>(List.of(19, 22, 0, 13, 4, 35));
  private static int n1 = IntArray1.size();

  private static void selectionSort1() {
    for (int i = 0; i < n1 - 1; i++) {
      int minIndex = i;
      for (int j = i; j < n1 - 1; j++) {
        if (IntArray1.get(j) < IntArray1.get(minIndex)) {
          minIndex = j;
        }
      }
      int minValue = IntArray1.remove(minIndex);
      IntArray1.add(i, minValue);
    }
    System.out.print(IntArray1);
  }

  /*
  Solution: Swap Values!
  Instead of all the shifting, swap the lowest value (0) with the first value (19) like below.
  We can swap values as shown below because the lowest value ends up in the correct position, and it does not matter where we put the other value we are swapping with, because it is not sorted yet.
     */
  private static ArrayList<Integer> intArray2 = new ArrayList<>(List.of(19, 22, 0, 13, 4, 35));
  private static int n2 = intArray2.size();

  private static void selectionSort2() {
    for (int i = 0; i < n2 - 1; i++) {
      int minIndex = i;
      for (int j = i; j < n2 - 1; j++) {
        if (intArray2.get(j) < intArray2.get(minIndex)) {
          minIndex = j;
        }
      }
      int temp = intArray2.get(i);
      intArray2.set(i, intArray2.get(minIndex));
      intArray2.set(minIndex, temp);
    }
    System.out.print(intArray2);
  }

  public static void main(String[] args) {
    double startTime1 = System.currentTimeMillis();
    System.out.println("Unsorted array 1: " + IntArray1);
    System.out.print("Sorted array 1: ");
    selectionSort1();
    double endTime1 = System.currentTimeMillis();
    System.out.println("\nTime taken using method 1: " + (endTime1 - startTime1) + " seconds");
    System.out.println();
    double startTime2 = System.currentTimeMillis();
    System.out.println("Unsorted array 2: " + intArray2);
    System.out.print("Sorted array 2: ");
    selectionSort2();
    double endTime2 = System.currentTimeMillis();
    System.out.println("\nTime taken using method 2: " + (endTime2 - startTime2) + " seconds");
  }
}
