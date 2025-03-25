package org.example.whilewait;

public class WaitNotifyExample {
  private static final Object lock = new Object();
  private static boolean isReady = false;

  public static void main(String[] args) {
    Thread waiter =
        new Thread(
            () -> {
              synchronized (lock) {
                while (!isReady) {
                  try {
                    System.out.println("Waiting for signal...");
                    lock.wait(); // Wait until notified
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
                System.out.println("Received signal! Proceeding...");
              }
            });

    Thread notifier =
        new Thread(
            () -> {
              synchronized (lock) {
                try {
                  Thread.sleep(2000);
                  isReady = true;
                  lock.notify(); // Notify the waiting thread
                  System.out.println("Sent notification.");
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    waiter.start();
    notifier.start();
  }
}
