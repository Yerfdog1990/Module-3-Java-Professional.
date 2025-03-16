package interface_segregation.good.practice;

public interface CircleCalculator {
    void calculateArea(double radius);
}
class Circle implements CircleCalculator {
    @Override
    public void calculateArea(double radius) {
        System.out.printf("Area of a circle: %.2f\n",(Math.PI * radius * radius));
    }
}
