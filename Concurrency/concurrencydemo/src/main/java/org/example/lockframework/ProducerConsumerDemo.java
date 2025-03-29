package org.example.lockframework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
  public static void main(String[] args) throws InterruptedException {
    Desktop desktop = new Desktop("This is a document");
    Thread producer = new Thread(desktop::typeWords);
    Thread consumer = new Thread(desktop::printWords);
    producer.start();
    consumer.start();

    producer.join();
    consumer.join();
  }
}

class Desktop {
  private final String document;
  private boolean isDone = false;
  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();

  public Desktop(String document) {
    this.document = document;
  }

  protected void typeWords() {
    lock.lock();
    try {
      while (isDone) {
        condition.await();
      }
      System.out.println("Document is ready to be typed");
      System.out.println(document.trim().length() + " words types on a desktop.");
      isDone = true;
      condition.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  protected void printWords() {
    lock.lock();
    try {
      while (!isDone) {
        condition.await();
      }
      System.out.println("Document is ready to be printed");
      Thread.sleep(1000);
      System.out.println("Document printed.");
      isDone = false;
      condition.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
