package org.example.datastructures.arrays;

/*
How it works:
1.Create a variable 'minVal' and set it equal to the first value of the array.
2.Go through every element in the array.
3.If the current element has a lower value than 'minVal', update 'minVal' to this value.
4.After looking at all the elements in the array, the 'minVal' variable now contains the lowest value.

Time complexity:
Finding the lowest value in an array requires checking each element once, so the time complexity is O(n).
 */
public class LowestValue {
  private static int[] intArray = {19, 22, 0, 13, 4, 35};
  private static int minVal = intArray[0];

  private static int printMinVal(int[] intArray) {
    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] < minVal) {
        minVal = intArray[i];
      }
    }
    return minVal;
  }

  public static void main(String[] args) {
    System.out.println("Lowest value in the array is: " + printMinVal(intArray));
  }
}
