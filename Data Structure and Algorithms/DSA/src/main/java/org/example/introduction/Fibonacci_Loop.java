package org.example.introduction;

public class Fibonacci_Loop {
  public static void printFibonacci(int n) {
    int firstNum = 0, secondNum = 1;
    System.out.print("Fibonacci Series: " + firstNum + ", " + secondNum);
    for (int i = 2; i < n; i++) {
      int nextNum = firstNum + secondNum;
      System.out.print(", " + nextNum);
      firstNum = secondNum;
      secondNum = nextNum;
    }
  }

  public static void main(String[] args) {
    printFibonacci(100);
  }
}
