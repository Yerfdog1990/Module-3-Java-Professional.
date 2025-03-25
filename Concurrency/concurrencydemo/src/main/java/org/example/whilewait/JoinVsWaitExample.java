package org.example.whilewait;

public class JoinVsWaitExample {
  public static void main(String[] args) {
    Thread t1 =
        new Thread(
            () -> {
              System.out.println("Thread t1: Running...");
            });

    // Using join()
    t1.start();
    try {
      t1.join(); // Main thread waits for t1 to finish.
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Main thread resumes after t1.");

    // Using wait()
    Object lock = new Object();
    Thread t2 =
        new Thread(
            () -> {
              synchronized (lock) {
                try {
                  System.out.println("Thread t2: Waiting...");
                  lock.wait(); // Pauses t2, releases lock, waits for notify.
                  System.out.println("Thread t2: Resumed after notify.");
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    Thread notifier =
        new Thread(
            () -> {
              synchronized (lock) {
                System.out.println("Notifier thread: Notifying t2.");
                lock.notify(); // Wakes up thread t2.
              }
            });

    t2.start();
    try {
      Thread.sleep(1000); // Ensures t2 enters waiting state
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    notifier.start();
  }
}
