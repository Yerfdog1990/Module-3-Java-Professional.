package happenbeforerules.volatilevariable;

public class Voting {
    private static volatile boolean isEven = false;
    public static void main(String[] args) {
    Thread thread1 = new Thread(() -> System.out.println(writeFile()));
    Thread thread2 = new Thread(() -> System.out.println(readFile()));
        thread1.start();
        thread2.start();
    }
    public static boolean writeFile() {
        return isEven = true;
    }
    public static boolean readFile() {
        return isEven;
    }
}
/*
3️⃣ Volatile Variable Rule
Definition:
A write to a volatile variable happens-before every subsequent read of that same variable.

✅ Guarantees:
If writer() runs first, reader() will see isEven = true.

Note:
⚠ Does NOT guarantee atomicity!
volatile int count = 0;
count++; // Not atomic! Use synchronized or AtomicInteger instead.
 */