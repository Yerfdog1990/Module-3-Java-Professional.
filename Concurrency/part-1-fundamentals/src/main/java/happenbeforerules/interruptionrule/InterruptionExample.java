package happenbeforerules.interruptionrule;

public class InterruptionExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000); // Interrupted during sleep
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        });

        t.start();
        t.interrupt(); // Happens-before the thread detects the interruption
    }
}

/*
Interruption Rule
Definition:
A thread calling interrupt() on another thread happens-before the interrupted thread detects the interrupt.

✅ Guarantees:
interrupt() ensures that the thread will detect the interruption.
 */
