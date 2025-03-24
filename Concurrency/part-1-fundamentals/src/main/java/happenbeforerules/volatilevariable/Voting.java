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
