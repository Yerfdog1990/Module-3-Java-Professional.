package org.example.datastructures.arrays;

import java.util.Arrays;

public class BubbleSort {
  /*
  How it works:
  1. Start with an array containing the values to sort.
  2. Use an inner loop to compare adjacent values and swap them if the first is greater than the second.
  3. After each pass of the inner loop, the largest unsorted value "bubbles" to its correct position.
  4. The inner loop runs fewer iterations on each subsequent pass, as the last elements are already sorted.
  5. An outer loop ensures the inner loop runs n - 1 times for an array of size n.

  Time complexity:
  - Best case: O(n) [when the array is already sorted].
  - Average and worst case: O(n^2) [when the array is sorted in reverse or unordered].
     */
  private static int[] intArray = {19, 22, 0, 13, 4, 35};
  private static int n = intArray.length;

  private static void bubbleSort() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (intArray[j] > intArray[j + 1]) {
          // Swap intArray[j] and intArray[j+1]
          int temp = intArray[j];
          intArray[j] = intArray[j + 1];
          intArray[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(intArray));
  }

  public static void main(String[] args) {
    System.out.printf("Unsorted array: %s\n", Arrays.toString(intArray));
    System.out.print("Sorted array: ");
    bubbleSort();
  }
}
