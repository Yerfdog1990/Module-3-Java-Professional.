package org.example.lockframework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo1 {
  public static void main(String[] args) {
    LockDemo1 lockDemo1 = new LockDemo1();
    Thread t1 = new Thread(lockDemo1::firsIncrement, "Thread 1");
    Thread t2 = new Thread(lockDemo1::firsIncrement, "Thread 2");
    t1.start();
    t2.start();
  }

  Lock lock = new ReentrantLock();
  int count = 0;

  void firsIncrement() {
    lock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " acquired a lock");
      for (int i = 0; i < 10; i++) {
        count++;
        System.out.println(
            Thread.currentThread().getName() + " incremented count to " + count + ".");
      }
    } catch (Exception e) {
      Thread.currentThread().interrupt();
      System.out.println("Interrupted");
    } finally {
      System.out.println(Thread.currentThread().getName() + " released a lock");
      System.out.println("Count is now: " + count + ".");
      System.out.println("===================================================");
      lock.unlock();
    }
  }
}
