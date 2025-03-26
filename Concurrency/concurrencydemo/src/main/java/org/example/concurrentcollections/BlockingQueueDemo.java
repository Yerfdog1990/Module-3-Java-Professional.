package org.example.concurrentcollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);
    Thread producerThread = new Thread(producer.runnable);
    Thread consumerThread = new Thread(consumer.runnable);
    producerThread.start();
    consumerThread.start();

    producerThread.join();
    consumerThread.join();
  }
}

// Task to produce items
class Producer {
  private BlockingQueue<String> queue;

  public Producer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  Runnable runnable =
      () -> {
        for (int i = 0; i < 10; i++) {
          try {
            String item = "item " + i;
            queue.put(item);
            System.out.println("Produced: " + item);
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      };
}

// Task to consume item from BlockingQueue
class Consumer {
  private BlockingQueue<String> queue;

  public Consumer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  Runnable runnable =
      () -> {
        while (true) {
          try {
            String item = queue.take();
            System.out.println("Consumed: " + item);
            Thread.sleep(800);
          } catch (InterruptedException e) {
            e.printStackTrace();
            break;
          }
        }
      };
}
