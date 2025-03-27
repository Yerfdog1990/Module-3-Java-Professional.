package org.example.callableandfuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableDemo1 implements Callable<String> {
  @Override
  public String call() throws Exception {
    Random random = new Random();
    int time = random.nextInt(100);
    Thread.sleep(time);
    return "Task completed after " + time + " milliseconds.";
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // Unlike Runnable, a Callable instance cannot be passed directly to a thread.
    Callable<String> callable = new CallableDemo1();
    // A Callable instance must be wrapped by a Future and submitted to an executor.
    Future<String> future = executor.submit(callable);
    // The Thread retrieves the result from the Future object. The get() method can be used to
    // obtain the result.
    System.out.println(future.get());
    executor.shutdown();
  }
}
