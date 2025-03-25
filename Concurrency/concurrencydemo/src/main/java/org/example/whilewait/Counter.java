package org.example.whilewait;

public class Counter {
  private static int count = 0;

  // Main method
  public static void main(String[] args) {
    Counter counter = new Counter();
    Thread t1 =
        new Thread(
            () -> {
              try {
                counter.increment();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
    Thread t2 =
        new Thread(
            () -> {
              try {
                counter.getCount();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
    t1.start();
    t2.start();
    try {
      t1.join(); // Wait for both threads to finish
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Code below will only execute after both threads have completed
    System.out.println("Threads t1 and t2 have finished execution");
  }

  public synchronized void increment() throws InterruptedException {
    while (count != 0) {
      wait(); // Wait until count becomes 0
    }
    for (int i = 0; i < 10; i++) {
      count++;
      System.out.println("count incremented to " + count);
    }
    notify(); // Notify waiting threads after the update
  }

  public synchronized void getCount() throws InterruptedException {
    while (count == 0) {
      wait(); // Wait until count changes from 0
    }
    System.out.println("Count is now: " + count); // Printing the current count
    count = 0; // Reset count, allowing increment() to run again
    notify(); // Notify waiting threads after resetting the count
  }
}
