package org.example.introduction;

public class Fibonacci_DynamicProgramming {
  public static void findFibonacciSeries(int n) {
    int[] fib = new int[n + 1];
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i <= n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    for (int i = 0; i <= n; i++) {
      System.out.print(fib[i] + ", ");
    }
  }

  public static void main(String[] args) {
    double startTime = System.currentTimeMillis();
    System.out.print("Fibonacci Series: ");
    findFibonacciSeries(9);
    double endTime = System.currentTimeMillis();
    System.out.println("\nTime taken: " + (endTime - startTime) + " seconds");
  }
}
