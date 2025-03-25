package happenbeforerules.programorder;

/*
Program order rule.
Each action in a thread happens‐before every action in that thread that comes later in the program order.
 */
public class ProgramOrderDemo {
    private static int x;
    public static void main(String[] args) {

        executeInOrder();
        executeOutOfOrder();
    }
    public static void executeInOrder() {
        Thread thread1 = new Thread(()->{
            int x = 5;
            int y = x + 10;
            System.out.println("Happens-Before Relationship:");
            System.out.printf("Thread 1: x = %d, y = %d\n", x, y);
        });
        thread1.start();
    }
    public static void executeOutOfOrder() {
        Thread thread2 = new Thread(() -> {
            x = 5;  // (1) Writing x
            System.out.println("\nNo Happens-Before Relationship:");
            System.out.printf("Thread 2: x = %d\n", x);
        });

        Thread thread3 = new Thread(() -> {
            int y = x + 5;  // (2) Reading x
            System.out.printf("Thread 3: x = %d, y = %d\n", x, y);
        });
        thread2.setPriority(Thread.MIN_PRIORITY); // x = 10, y = 15  -> If thread1 writes before thread2 reads
        thread3.setPriority(Thread.MAX_PRIORITY); // x = 0, y = 5    -> If thread2 reads before thread1 writes
        thread2.start();
        thread3.start();
    }
}
