package concurrencyannotations;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
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
