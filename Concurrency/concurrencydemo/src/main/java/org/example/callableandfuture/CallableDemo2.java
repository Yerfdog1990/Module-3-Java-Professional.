package org.example.callableandfuture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo2 implements Callable<String> {
  @Override
  public String call() throws Exception {
    Thread.sleep(1000);
    return Thread.currentThread().getName() + " completed.";
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    List<Future<String>> list = new ArrayList<>();
    Callable<String> callable = new CallableDemo2();

    for (int i = 0; i < 10; i++) {
      Future<String> future = executor.submit(callable);
      list.add(future);
      System.out.println("Submitted task " + i);
    }
    for (Future<String> future : list) {
      try {
        System.out.println(new Date() + " : " + future.get());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
