package org.example.introduction;

public class fibonacci_Recursion {
  public static int findFibonacciSeries(int n) {
    if (n <= 1) {
      return n;
    } else {
      return findFibonacciSeries(n - 1) + findFibonacciSeries(n - 2);
    }
  }

  public static void main(String[] args) {
    int count = 10;
    for (int i = 0; i < count; i++) {
      System.out.print(findFibonacciSeries(i) + ", ");
    }
  }
}
