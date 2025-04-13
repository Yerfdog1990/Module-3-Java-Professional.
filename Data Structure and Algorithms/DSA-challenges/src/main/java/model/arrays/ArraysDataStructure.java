package model.arrays;

public class ArraysDataStructure {
  public static int findClosestNumber(int[] intArray) {
    if (intArray == null || intArray.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int closestNum = intArray[0];
    for (int num : intArray) {
      if (Math.abs(closestNum) > Math.abs(num)) {
        closestNum = num;
      } else if (Math.abs(closestNum) == Math.abs(num) && closestNum < num) {
        closestNum = num;
      }
    }
    return closestNum;
  }
}
