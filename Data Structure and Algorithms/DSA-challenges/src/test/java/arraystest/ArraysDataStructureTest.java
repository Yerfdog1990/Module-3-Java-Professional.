package arraystest;

import static model.arrays.ArraysDataStructure.findClosestNumber;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArraysDataStructureTest {
  @Test
  void testFindClosestNumber() {
    int[] intArray = {1, 2, -1, 3, 4, -2, 5};
    int expected = 1;
    int actual = findClosestNumber(intArray);
    assertEquals(expected, actual);
    System.out.println("Expected: " + expected);
    System.out.println("Actual: " + actual);
  }
}
