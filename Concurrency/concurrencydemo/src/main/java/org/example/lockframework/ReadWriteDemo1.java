package org.example.lockframework;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo1 {
  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  Lock readLock = readWriteLock.readLock();
  Lock writeLock = readWriteLock.writeLock();
  List<String> list = new java.util.ArrayList<>();

  public static void main(String[] args) throws InterruptedException {
    ReadWriteDemo1 demo = new ReadWriteDemo1();
    demo.read("John");
    demo.read("Jane");
    demo.read("Jill");
    demo.read("Joe");
    demo.write();
  }

  protected void read(String name) throws InterruptedException {
    readLock.lock();
    try {
      list.add(name);
      for (int i = 0; i < list.size(); i++) {
        System.out.println("Added " + list.get(i) + " to the list.");
        System.out.println("I have added " + (i + 1) + " student(s).");
        Thread.sleep(100);
      }
      Thread.sleep(1000);
    } finally {
      readLock.unlock();
    }
  }

  protected void write() throws InterruptedException {
    writeLock.lock();
    try {
      System.out.println("List of students added: " + list);
      Thread.sleep(1000);
    } finally {
      writeLock.unlock();
    }
  }
}
