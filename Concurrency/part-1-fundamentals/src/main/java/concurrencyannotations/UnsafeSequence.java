package concurrencyannotations;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe // This class can cause race conditions if accessed by multiple threads.
public class UnsafeSequence {
    private int count = 0;
    public void getCount() {
    System.out.println(count++); // Not thread-safe!
    }
    public static void main(String[] args) {
        UnsafeSequence sequence = new UnsafeSequence();
        Thread t1 = new Thread(()->{
            for(int i=0; i<10; i++) {
                sequence.getCount();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0; i<10; i++) {
                sequence.getCount();
            }
        });
        t1.start();
        t2.start();
    }
}
/*
@NotThreadSafe
📌 Indicates that a class is not thread-safe.
Used as a warning that multiple threads can cause unexpected behavior.
If used in a multithreaded environment, the developer must add synchronization.
 */
