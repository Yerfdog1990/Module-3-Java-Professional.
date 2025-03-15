package structural.pattern.bridge;

public class Client {
    public static void main(String[] args) {
        DrawAPI redCircle = new RedCircle();
        redCircle.drawCircle(10, 10, 10);
        DrawAPI greenCircle = new GreenCircle();
        greenCircle.drawCircle(10, 10, 10);
    }
}
