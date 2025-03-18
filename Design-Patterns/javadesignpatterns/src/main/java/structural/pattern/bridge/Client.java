package structural.pattern.bridge;

public class Client {
    public static void main(String[] args) {
        DrawAPI redCircle = new RedCircle();
        redCircle.drawCircle(10, 10, 10);
        DrawAPI greenCircle = new GreenCircle();
        greenCircle.drawCircle(10, 10, 10);
        Circle circle1 = new Circle(redCircle);
        circle1.drawAPI.drawCircle(10, 10, 10);
        Circle circle2 = new Circle(greenCircle);
        circle2.drawAPI.drawCircle(10, 10, 10);
    }
}
