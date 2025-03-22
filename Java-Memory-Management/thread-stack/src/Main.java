import java.util.Date;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Date createDate = new Date();
    Thread thread1 =
        new Thread(
            () -> {
              System.out.println(createDate);
            });
    Thread thread2 = new Thread(() -> System.out.println(createDate));
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
  }
}
