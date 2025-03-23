package concurrencyannotations;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe // The synchronized keyword ensures that only one thread at a time modifies count.
public class SafeSequence {
    @GuardedBy("this") private int count = 0;
    public synchronized void getCount() {
        System.out.println(count++); // Now thread-safe!
    }
    public static void main(String[] args) {
        SafeSequence sequence = new SafeSequence();
        Thread thread1 = new Thread(()->{
            for(int i=0; i<10; i++) {
                sequence.getCount();
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i=0; i<10; i++) {
                sequence.getCount();
            }
        });
        thread1.start();
        thread2.start();
    }
}
/*
@ThreadSafe
📌 Indicates that a class is thread-safe.
Implies the class has built-in synchronization to handle multiple threads safely.
Helps developers use the class with confidence in concurrent programs.
 */
