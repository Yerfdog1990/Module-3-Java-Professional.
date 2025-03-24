package happenbeforerules.transitivity;

public class TransitivityExample {
    private volatile int count = 1;

    public static void main(String[] args){
        TransitivityExample example = new TransitivityExample();
        int x = example.writer();
        int y = example.reader1();
        int z = example.reader2();
        System.out.println("x: " + x + "\ny: " + y + "\nz: " + z);
    }
    public int writer() {
        int x = count++; // (1)
        return x;
    }

    public int reader1() {
        int y = count++; // (2) Happens-after (1)
        return y;
    }

    public int reader2() {
        int z = count++; // (3) Happens-after (2)
        return z;
    }
}

/*
Transitivity
Definition:
If A happens-before B and B happens-before C, then A happens-before C.

✅ Guarantees:
If (1) → (2), and (2) → (3), then (1) → (3).
Ensures visibility across multiple operations.
 */
