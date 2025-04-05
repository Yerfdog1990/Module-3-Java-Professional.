package org.example.datastructures.arrays;

import java.util.Arrays;

public class BubbleSort {
  /*
  How it works:
  1. Start with the first element of the array and compare it to the next element.
  2. If the first element is greater than the second, swap them.
  3. Move to the next pair of elements and repeat the process for the entire array.
  4. Repeat the entire process for the rest of the array, excluding the last sorted element each time.
  5. Continue this process until no swaps are needed, indicating that the array is sorted.

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
