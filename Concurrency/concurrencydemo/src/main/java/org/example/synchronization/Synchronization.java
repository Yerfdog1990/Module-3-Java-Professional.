package org.example;

public class Synchronization {
  public static void main(String[] args) {
    Counter counter = new CounterImpl();
    Worker worker1 = new Worker(counter);
    Worker worker2 = new Worker(counter);
    worker1.start();
    worker2.start();
    try {
      worker1.join();
      worker2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Counter value is " + counter.getCountInc());
    System.out.println("Counter value is " + counter.getCountDec());
  }
}

interface Counter {
  void increment();

  void decrement();

  int getCountInc();

  int getCountDec();
}

class CounterImpl implements Counter {
  int countInc = 0;
  int countDec;

  @Override
  public synchronized void increment() {
    countInc++;
  }

  @Override
  public synchronized void decrement() {
    countInc--;
  }

  @Override
  public int getCountInc() {
    return countInc;
  }

  @Override
  public int getCountDec() {
    return countDec;
  }
}

class Worker extends Thread {
  Counter counter;

  public Worker(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      counter.increment();
    }
  }
}
