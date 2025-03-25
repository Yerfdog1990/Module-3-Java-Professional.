package org.example.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
  private static final AtomicInteger counter1 = new AtomicInteger(0);
  private static int counter2 = 0;

  // Main method
  public static void main(String[] args) {
    Counter counter = new Counter();
    // Synchronized increment thread
    Thread thread1 = new Thread(counter::synchronizedIncrement);
    Thread thread2 = new Thread(counter::synchronizedIncrement);

    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Final counter of the synchronized increment: " + counter2);

    // Atomic increment thread
    Thread thread3 = new Thread(counter::atomicIncrement);
    Thread thread4 = new Thread(counter::atomicIncrement);
    thread3.start();
    thread4.start();
    try {
      thread3.join();
      thread4.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Final counter of the atomic increment: " + counter1.get());
  }

  public synchronized void synchronizedIncrement() {
    for (int i = 0; i < 10000; i++) {
      counter2++;
    }
  }

  public void atomicIncrement() {
    for (int i = 0; i < 10000; i++) {
      counter1.incrementAndGet();
    }
  }
}
