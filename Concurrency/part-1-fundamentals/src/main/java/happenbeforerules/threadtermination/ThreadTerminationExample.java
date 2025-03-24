package happenbeforerules.threadtermination;

public class ThreadTerminationExample {
    private static int count = 0;
    public static void main(String[] args){
        Thread thread = new Thread(()-> count = 100);
        thread.start();
        try {
            thread.join(); // Ensures all writes inside thread are visible
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Count value: " +count); // Guaranteed to print 10
    }
}

/*
Thread Termination Rule
Definition:
Any action in a thread happens-before another thread detects its termination (via Thread.join() or Thread.isAlive()).

✅ Guarantees:
After join(), the main thread sees all changes made by thread.
 */
