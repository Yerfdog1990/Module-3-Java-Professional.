package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
  /*
  How Insertion Sort Works:
  - The Insertion Sort algorithm works by dividing the array into a sorted portion and an unsorted portion.
  - Initially, the first element is considered the sorted portion.
  - Each subsequent element from the unsorted portion is compared with elements in the sorted portion to find its correct position.
  - This continues until all elements from the unsorted portion have been inserted into the sorted portion.

  Number of Iterations:
  - For an array of size n, the algorithm does not sort the first value (already sorted).
  - Hence, the outer loop runs n - 1 times to examine all remaining elements.

  Time Complexity:
  - Best Case: O(n), when the array is already sorted.
  - Average Case: O(n^2), when the array is in random order.
  - Worst Case: O(n^2), when the array is sorted in reverse order.

  Implementation Steps:
  - Declare or pass an array containing the values to sort.
  - Use an outer loop to iterate through values starting from the second element (index 1).
  - Use an inner loop to compare the selected value with values in the sorted portion and find the correct position for it.
  */
  private static ArrayList<Integer> intArray1 = new ArrayList<>(List.of(19, 22, 0, 13, 4, 35));
  private static int n1 = intArray1.size();

  private static void insertionSort1() {
    for (int i = 1; i < n1; i++) {
      int insertionIndex = i;
      int currentValue = intArray1.remove(i);
      for (int j = i - 1; j >= 0; j--) {
        if (intArray1.get(j) > currentValue) {
          insertionIndex = j;
        }
      }
      intArray1.add(insertionIndex, currentValue);
    }
  }

  /*
  Insertion Sort Improvement
  Insertion Sort can be improved a little bit more.
  The way the code above first removes a value and then inserts it somewhere else is intuitive. It is how you would do Insertion Sort physically with a hand of cards for example. If low value cards are sorted to the left, you pick up a new unsorted card, and insert it in the correct place between the other already sorted cards.
  The problem with this way of programming it is that when removing a value from the array, all elements above must be shifted one index place down:
  Removing an element from an array
  And when inserting the removed value into the array again, there are also many shift operations that must be done: all following elements must shift one position up to make place for the inserted value:
  Inserting an element into an array
  These shifting operations can take a lot of time, especially for an array with many elements.

  Improved Solution
  We can avoid most of these shift operations by only shifting the values necessary:
  In the image above, first value 7 is copied, then values 11 and 12 are shifted one place up in the array, and at last value 7 is put where value 11 was before.
  The number of shifting operations is reduced from 12 to 2 in this case.
  This improvement is implemented in the example below:
   */
  private static int[] intArray2 = {19, 22, 0, 13, 4, 35};
  private static int n2 = intArray2.length;

  private static void insertionSort2() {
    for (int i = 1; i < n2; i++) {
      int indexToInsert = i;
      int currentValue = intArray2[i];
      for (int j = i - 1; j >= 0; j--) {
        if (intArray2[j] > currentValue) {
          intArray2[j + 1] = intArray2[j];
          indexToInsert = j;
        } else {
          break;
        }
      }
      intArray2[indexToInsert] = currentValue;
    }
  }

  public static void main(String[] args) {
    double startTime1 = System.currentTimeMillis();
    System.out.println("Unsorted array: " + intArray1);
    insertionSort1();
    System.out.println("Sorted array: " + intArray1);
    double endTime1 = System.currentTimeMillis();
    System.out.println("Time taken using method 1: " + (endTime1 - startTime1) + " seconds");
    System.out.println();
    double startTime2 = System.currentTimeMillis();
    System.out.println("Unsorted array: " + Arrays.toString(intArray2));
    insertionSort2();
    System.out.println("Sorted array: " + Arrays.toString(intArray2));
    double endTime2 = System.currentTimeMillis();
    System.out.println("Time taken using method 2: " + (endTime2 - startTime2) + " seconds");
  }
}
