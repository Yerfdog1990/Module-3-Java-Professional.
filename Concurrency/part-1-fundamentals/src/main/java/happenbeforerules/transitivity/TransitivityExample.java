package happenbeforerules.transitivity;

public class TransitivityExample {
    private volatile int count = 1;

    public static void main(String[] args){
        TransitivityExample example = new TransitivityExample();
        int x = example.writer();
        int y = example.reader1();
        int z = example.reader2();
        System.out.println("Count increment to: " + x + "\nCount incremented to: " + y + "\nCount incremented to: " + z);
    }
    public int writer() {
        return count++; // (1)
    }

    public int reader1() {
        return count++; // (2) Happens-after (1)
    }

    public int reader2() {
        return count++; // (3) Happens-after (2)
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
