package org.example.concurrentcollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionDemo {
  static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

  Runnable runnable =
      () -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println(
              Thread.currentThread().getName()
                  + " interrupted when trying to add element to the list.");
        }
        // Child thread trying to add new element in the Collection object
        list.add("D");
      };

  // Main method to run main thread adding elements to the list
  public static void main(String[] args) throws InterruptedException {
    list.add("A");
    list.add("B");
    list.add("C");
    ConcurrentCollectionDemo mainThread = new ConcurrentCollectionDemo();
    Thread t1 = new Thread(mainThread.runnable);
    t1.start();

    // Use Iterator interface to transverse over the list
    Iterator<String> iterator = list.iterator();
    System.out.print(Thread.currentThread().getName() + " added elements: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ", ");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("\nUpdated list: " + list);
  }
}
