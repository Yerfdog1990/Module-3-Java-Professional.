package happenbeforerules.threadstart;

public class ThreadStartDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> System.out.println(Thread.currentThread().getName()+ " is running!"));
        thread.start(); // Happens-before the run() method executes
    }
}

/*
Thread Start Rule
Definition:
A call to Thread.start() on a new thread happens-before any actions in that thread.

✅ Guarantees:
start() ensures that all writes before start() are visible to the new thread.
 */
