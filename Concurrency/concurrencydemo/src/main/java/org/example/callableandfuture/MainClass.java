package org.example.callableandfuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainClass {
  public static void main(String[] args) {
    // Create a map with message and delay values
    Map<String, Long> input = new HashMap<>();
    input.put("Hello", 1L);
    input.put("Hi", 3L);
    input.put(null, 2L); // Add a null message value for testing purposes

    // For each message and delay value in the map, schedule a task using the MessageScheduler class
    input.forEach(
        (message, delay) -> {
          // Create a new FutureTask that will hold the result of the MessageScheduler task
          final FutureTask<Boolean> futureTask =
              new FutureTask<>(new MessageScheduler(message, delay));
          // Create a new thread for the FutureTask
          Thread thread = new Thread(futureTask);
          thread.start();

          try {
            // Get the result of the FutureTask and print a message indicating whether the task was
            // successful or not
            final boolean result = futureTask.get();
            System.out.println(
                result ? message + " :scheduled successfully" : message + " :schedule failed");
          } catch (InterruptedException | ExecutionException e) {
            // If an InterruptedException or ExecutionException is thrown, print the exception
            // message
            System.out.println(e.getMessage());
          }
        });
  }

  // This class schedules a message to be printed after a certain delay
  static class MessageScheduler implements Callable<Boolean> {
    private final String message; // The message to be printed
    private final long delay; // The delay before the message is printed

    // Constructor for the MessageScheduler class
    public MessageScheduler(final String message, final long delay) {
      this.message = message;
      this.delay = delay;
    }

    // The call method is called when the thread is started and returns a Boolean value
    @Override
    public Boolean call() {
      try {
        // Check if the message is null and throw a NullPointerException if it is
        if (message == null) {
          throw new NullPointerException("message should not be null");
        }
        // Sleep for the specified delay
        Thread.sleep(delay);
        // Print the message to the console
        System.out.println(message);
        // Return true to indicate that the task was successful
        return true;
      } catch (InterruptedException | NullPointerException e) {
        // If an InterruptedException or NullPointerException is thrown, return false
        return false;
      }
    }
  }
}
