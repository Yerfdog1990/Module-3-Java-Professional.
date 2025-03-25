package org.example.whilewait;

public class JoinExample {
  public static void main(String[] args) {
    Thread thread1 =
        new Thread(
            () -> {
              try {
                Thread.sleep(1000);
                System.out.println("Thread 1 completed.");
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    thread1.start();

    try {
      thread1.join(); // Main thread waits for thread1 to finish
      System.out.println("Main thread resumes after thread1.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
