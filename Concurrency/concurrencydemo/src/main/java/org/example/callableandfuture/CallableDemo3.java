package org.example.callableandfuture;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo3 implements Callable<String> {
  @Override
  public String call() throws Exception {
    for (int i = 0; i < 10; i++) {
      System.out.printf("%s completed task %d\n", Thread.currentThread().getName(), i);
    }
    Thread.sleep(1000);
    return "Task completed";
  }

  // Main method
  public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Callable<String> callable = new CallableDemo3();
    Future<String> future = executor.submit(callable);
    System.out.println("Main thread is running.");
    System.out.println(future.get() + " at " + new Date());
    executor.shutdown();
  }
}
