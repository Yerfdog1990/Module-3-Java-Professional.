package happenbeforerules.monitorlock;

import net.jcip.annotations.ThreadSafe;

import static java.lang.Thread.sleep;

@ThreadSafe
public class SharedResource {
    private int counter = 10;
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
      Thread thread1 = new Thread(()->{
          for(int i=0; i<10; i++) {
              resource.increment();
              System.out.println("Thread 1 incremented to " +resource.getCounter());
          }
          try {
              sleep(100);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      });
    Thread thread2 =
        new Thread(
            () -> {
              try {
                Thread.sleep(300);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("Thread 2 reads counter value as " +resource.getCounter());
            });
      thread1.start();
      thread2.start();
    }
    public synchronized void increment() {
        counter++;
    }
    public synchronized int getCounter () {
        return counter;
  }
}
    

