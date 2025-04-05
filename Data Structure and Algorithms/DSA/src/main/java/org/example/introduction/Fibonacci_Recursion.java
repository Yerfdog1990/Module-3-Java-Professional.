package org.example.introduction;

public class Fibonacci_Recursion {
  // Method 1: Naive Recursive Approach
  public static int findFibonacciSeries1(int n) {
    if (n <= 1) { // Base
      return n;
    } else {
      return findFibonacciSeries1(n - 1) + findFibonacciSeries1(n - 2);
    }
  }

  // Method 2: Recursive with Counter
  private static int counter = 2;

  public static void findFibonacciSeries2(int num1, int num2) {
    if (counter <= 9) {
      int newNum = num1 + num2;
      System.out.print(newNum);
      counter++;
      System.out.print(", ");
      findFibonacciSeries2(num2, newNum);
    }
  }

  public static void main(String[] args) {
    // Calling method 1
    double startTime1 = System.currentTimeMillis();
    int count = 10;
    System.out.print("Fibonacci series: ");
    for (int i = 0; i < count; i++) {
      System.out.print(findFibonacciSeries1(i) + ", ");
    }
    double endTime1 = System.currentTimeMillis();
    System.out.println("\nTime taken using method 1: " + (endTime1 - startTime1) + " seconds");
    System.out.println();
    // Calling method 2
    double startTime2 = System.currentTimeMillis();
    System.out.print("Fibonacci series: " + 0 + ", " + 1 + ", ");
    findFibonacciSeries2(0, 1);
    double endTime2 = System.currentTimeMillis();
    System.out.println("\nTime taken using method 2: " + (endTime2 - startTime2) + " seconds");
  }
}
