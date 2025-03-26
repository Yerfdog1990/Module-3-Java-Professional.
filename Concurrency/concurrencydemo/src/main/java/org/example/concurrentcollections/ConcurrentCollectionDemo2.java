package org.example.concurrentcollections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentCollectionDemo2 {
  static ConcurrentMap<String, Integer> studentMap = new ConcurrentHashMap<>();
  Runnable runnable =
      () -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println(
              Thread.currentThread().getName()
                  + " interrupted when trying to add element to the list.");
        }
        // Child thread trying to add new element in the Collection object
        studentMap.put("Mary", 4);
      };

  // Main method
  public static void main(String[] args) throws InterruptedException {
    studentMap.put("John", 15);
    studentMap.put("Jane", 23);
    studentMap.put("Bob", 10);
    ConcurrentCollectionDemo2 mainThread = new ConcurrentCollectionDemo2();
    Thread t1 = new Thread(mainThread.runnable);
    t1.start();
    Thread.sleep(2000);

    // Iterator over keys
    // Get an iterator for the entry set (key-value pairs)
    Iterator<Map.Entry<String, Integer>> iterator = studentMap.entrySet().iterator();

    // Iterate using the iterator
    while (iterator.hasNext()) {
      // Get the next entry
      Map.Entry<String, Integer> entry = iterator.next();

      // Access the key and value from the entry
      String key = entry.getKey();
      Integer value = entry.getValue();

      // Print key-value pairs
      System.out.println("Key: " + key + ", Value: " + value);
    }
  }
}
