package org.example.createthread;

public class ThreadCreation {
  public static void main(String[] args) {
    Thread thread =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                System.out.printf("Thread %d is running.\n", i);
              }
            });
    thread.start();
    System.out.println("Main thread ends here!.");
  }
}
