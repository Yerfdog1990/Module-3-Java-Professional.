package org.example.introduction;

public class CompareTimeComplexity {
  public static void main(String[] args) {
    double startTime1 = System.currentTimeMillis();
    System.out.print("Fibonacci Series (Time complexity: O(2^n)): ");
    for (int i = 0; i < 10; i++) {
      System.out.print(FibonacciSeries1(i) + ", ");
    }
    double endTime1 = System.currentTimeMillis();
    System.out.println(
        "\nTime taken using naive recursive approach: " + (endTime1 - startTime1) + " seconds");
    System.out.println();
    double startTime2 = System.currentTimeMillis();
    System.out.print("Fibonacci Series (Time complexity: 0(n)): " + 0 + ", " + 1 + " ,");
    FibonacciSeries2(0, 1);
    double endTime2 = System.currentTimeMillis();
    System.out.println(
        "\nTime taken using recursive approach with counter: "
            + (endTime2 - startTime2)
            + " seconds");
    System.out.println();
    double startTime3 = System.currentTimeMillis();
    System.out.print("Fibonacci Series (Time complexity: O(2^n)): ");
    FibonacciSeries3(10);
    double endTime3 = System.currentTimeMillis();
    System.out.println(
        "\nTime taken using iterative approach: " + (endTime3 - startTime3) + " seconds");
    System.out.println();
    double startTime4 = System.currentTimeMillis();
    System.out.print("Fibonacci Series (Time complexity: O(n)): ");
    FibonacciSeries4(9);
    double endTime4 = System.currentTimeMillis();
    System.out.println(
        "\nTime taken using dynamic programming approach: " + (endTime4 - startTime4) + " seconds");
  }

  /*
  Method 1: Naive Recursive Approach
  Big-O Time Complexity:
  This implementation recomputes the Fibonacci of smaller numbers multiple times.
  It generates a tree structure where every Fibonacci call makes two recursive calls until the base case is reached.
      - Time complexity: O(2^n) (exponential complexity).
      - Space complexity: O(n) due to the recursion stack.

  Explanation:
  For `n = 10`, the number of recursive calls grows exponentially, leading to significant computational overhead.
  This inefficiency is evident from the 6.0 seconds it took to compute for the first 10 Fibonacci numbers.

  Why slow?
  The same Fibonacci values are recalculated repeatedly without caching, leading to exponential growth of operations.
   */
  public static int FibonacciSeries1(int n) {
    if (n <= 1) {
      return n;
    } else {
      return FibonacciSeries1(n - 1) + FibonacciSeries1(n - 2);
    }
  }

  /*
  Method 2: Recursive with Counter
      - Big-O Time Complexity:
  This implementation tracks Fibonacci in linear order and calculates each number once.
  Instead of recomputing values, this method recursively propagates the last two computed Fibonacci numbers, making one recursive call per term.
      - Time complexity: O(n)
      - Space complexity: O(n) due to the recursion stack.

  Explanation:
  Each Fibonacci number is computed in a single step by simply adding the two previous numbers, avoiding the exponential overhead of recomputation.
  This is why this method is significantly faster, taking only 1.0 second.
     */
  public static int counter = 2;

  public static void FibonacciSeries2(int num1, int num2) {
    if (counter <= 9) {
      int newNum = num1 + num2;
      counter++;
      System.out.print(newNum + ", ");
      FibonacciSeries2(num2, newNum);
    }
  }

  /*
  Method 3: Iterative (Using For Loop)
  In this implementation, the method `FibonacciSeries3` is called inside a `for` loop for every number from `0` to `n`, which amplifies the inefficiency.
      - Big-O Time Complexity:
      Since `FibonacciSeries1` is called recursively inside the loop:
      - For each number `i`, `FibonacciSeries3(i)` has O(2^i) complexity.
      - Computation for all Fibonacci numbers up to `n` involves summing up time taken for all `i` values.
  So, total time complexity: O(2^0 + 2^1 + 2^2 + ... + 2^(n-1)) ≈ O(2^n).
      - Space complexity: O(n) (due to the recursion stack of Method 1).

  - Explanation:
  Since `FibonacciSeries3` is already an exponential algorithm, using it iteratively amplifies the inefficiency as it recomputes Fibonacci numbers for every `i`.
  This results in the longest computation time of 7.0 seconds for the first 10 numbers.

     */
  public static void FibonacciSeries3(int n) {
    int firstNum = 0, secondNum = 1;
    System.out.print(firstNum + ", " + secondNum + ", ");
    for (int i = 2; i < n; i++) {
      int nextNum = firstNum + secondNum;
      System.out.print(nextNum + ", ");
      firstNum = secondNum;
      secondNum = nextNum;
    }
  }

  /*
  Method 4: Dynamic Programming Approach
  In this implementation, we use an array to store already computed Fibonacci numbers and build the sequence iteratively from the base cases (`fib[0] = 0` and `fib[1] = 1`).
  Each subsequent Fibonacci number is calculated only once and stored, removing the need for redundant computations.
  Big-O Time Complexity:
    - Time Complexity: O(n)
      Each Fibonacci number is computed precisely once, and the computation involves only a simple addition operation (`fib[i] = fib[i-1] + fib[i-2]`) for every index `i`.
      The loop runs `n` times, so the computation scales linearly with the size of `n`.
  - Space Complexity: O(n)
      An array of size `n` is used to store the Fibonacci numbers, resulting in linear auxiliary space.
      If we only care about the immediate previous numbers, this could be further optimized to O(1).

  Explanation:
  The dynamic programming approach avoids any redundant computation by storing previously calculated Fibonacci numbers.
  Instead of recalculating the same values multiple times (as happens in naive recursion), it works iteratively, directly utilizing previously computed results.
  This method is efficient and takes significantly less time compared to the exponential recursion methods.
  However, it does use extra memory for the array of Fibonacci numbers (hence O(n) space complexity).
  For the computation of the first 10 Fibonacci numbers, the method has a linear performance and completes significantly faster than the recursive methods.
  Its speed, however, is constrained by the array allocation, which can contribute minor overhead at smaller values of `n`.
  Time taken: Dynamic programming approach took approximately 7.0 seconds, for the first 10 numbers due to only storing and accessing pre-computed values for addition.
       */
  public static void FibonacciSeries4(int n) {
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
}
