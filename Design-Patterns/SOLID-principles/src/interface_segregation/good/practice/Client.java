package interface_segregation.good.practice;

public class Client {
    public static void main(String[] args) {
        CircleCalculator circleCalculator = new Circle();
        circleCalculator.calculateArea(5);
        RectangleCalculator rectangleCalculator = new Rectangle();
        rectangleCalculator.calculateArea(5, 10);
    }
}
