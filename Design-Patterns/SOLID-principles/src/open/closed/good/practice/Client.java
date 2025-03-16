package open.closed.good.practice;

public class Client {
    public static void main(String[] args) {
        IAreaCalculator rectangle = new Rectangle();
        rectangle.calculateArea();
        IAreaCalculator square = new Square();
        square.calculateArea();
    }
}
